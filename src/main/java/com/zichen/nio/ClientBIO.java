package com.zichen.nio;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientBIO {
    public static void main(String[] args) throws Exception {
        Socket client = new Socket(InetAddress.getLocalHost(), 9090);

        OutputStream outputStream = client.getOutputStream();
        ObjectOutput bw = new ObjectOutputStream(outputStream);

        bw.writeObject("--once");
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String dateStr = simple.format(new Date());
        bw.writeObject(dateStr);
        bw.flush();
        bw.close();
        outputStream.close();
        client.close();
    }
}
