package com.serializablepack;

import java.io.*;

/**
 * @name: JavaSerializa
 * @description:
 * @author: zichen
 * @date: 2021/4/25  18:36
 */
public class JavaSerializa implements ISerializable{

    @Override
    public <T> byte[] serialize(T obj) {
        //ByteArrayOutputStream将obj转成字节数据
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            //ObjectOutputStream读取obj
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return (T) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
