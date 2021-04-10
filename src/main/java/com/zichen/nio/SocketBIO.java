package com.zichen.nio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketBIO {
    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(9090);
        System.out.println("new ServerSocket...");
        while (true) {
            final Socket accept = server.accept();
            int port = accept.getPort();
            new Thread(() -> {
                InputStream in = null;
                try {
                    in = accept.getInputStream();
                    BufferedReader inputStream = new BufferedReader(new InputStreamReader(in));
                    while(true) {
                        String s = inputStream.readLine();
                        if (s != null) {
                            System.out.println(s);
                        } else {
                            server.close();
                            break;
                        }
                    }
                    System.out.println("client off ... ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
