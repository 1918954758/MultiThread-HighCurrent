package com.zichen.nio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ServerBIO {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(9090);

            Socket accept = server.accept();
            InputStream inputStream = accept.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(inputStream);
            String str = (String) ois.readObject();
            String d = (String) ois.readObject();
            ois.close();
            accept.close();
            server.close();
            System.out.println(str);
            System.out.println(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
