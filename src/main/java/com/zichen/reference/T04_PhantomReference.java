package com.zichen.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.LinkedList;
import java.util.List;

/**
 * 虚引用
 */
public class T04_PhantomReference {
    private static final List<Object> LIST = new LinkedList<>();
    private static final ReferenceQueue<M> QUEUE = new ReferenceQueue<>();

    public static void main(String[] args) {
        //使用虚引用的时候，首先得有队列，同时还要指定这个虚引用所属的队列是哪一个。
        PhantomReference<M> phantomReference = new PhantomReference<>(new M(), QUEUE);

        new Thread(() -> {
            while (true) {
                LIST.add(new byte[1024 * 1024 * 10]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                System.out.println(phantomReference.get());
            }
        }).start();

        //监控堆外内存的垃圾回收线程
        new Thread(() -> {
            while (true) {
                //监控这个队列里面有没有信息加进来，如果有，则拿出来
                Reference<? extends M> poll = QUEUE.poll();
                //如果拿出来了，说明某个管理堆外内存的对象被回收了
                if (poll != null) {
                    System.out.println("---虚引用对象被jvm回收了---" + poll);
                }
            }
        }).start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
