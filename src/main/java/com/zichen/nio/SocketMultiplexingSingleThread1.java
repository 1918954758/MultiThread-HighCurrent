package com.zichen.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * NIO
 */
public class SocketMultiplexingSingleThread1 {
    private ServerSocketChannel server = null;
    private Selector selector = null;
    int port = 9090;

    public void initServer() {
        try {
            server = ServerSocketChannel.open();
            server.configureBlocking(false);//非阻塞
            server.bind(new InetSocketAddress(port));

            selector = Selector.open();//操作系统和jvm的一个中间对象
            server.register(selector, SelectionKey.OP_ACCEPT);//把server注册到selector上
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        initServer();
        System.out.println("server start ...");
        while(true) {
            Set<SelectionKey> keys = selector.keys();

            try {
                //一个线程，多路调用，，就是Multiplexing
                //每次都重复传递数据
                //每次调用都会触发内核遍历
                while (selector.select() > 0) {
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();//返回一个有状态的集合
                    Iterator<SelectionKey> iter = selectionKeys.iterator();
                    while (iter.hasNext()) {
                        SelectionKey key = iter.next();
                        iter.remove();//hoop if not remove iter for set
                        if (key.isAcceptable()) {//接收
                            acceptHandler(key);
                        } else if (key.isReadable()) {//读取
                            acceptHandler(key);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void acceptHandler(SelectionKey key) {
        try {
            ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
            SocketChannel client = ssc.accept();//接收客户端请求
            server.configureBlocking(false);//设置为非阻塞

            //开辟一个缓存空间
            ByteBuffer buffer = ByteBuffer.allocate(8192);

            client.register(selector, SelectionKey.OP_READ, buffer);//把client注册到selector上
            System.out.printf("连接新客户端 ： ", client.getRemoteAddress());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
