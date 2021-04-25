package com.serializablepack;

/**
 * @name: SerializableTest
 * @description:
 * @author: zichen
 * @date: 2021/4/25  18:50
 */
public class SerializableTest {

    public static void main(String[] args) {
        JavaSerializaWithFile javaSerializaWithFile = new JavaSerializaWithFile();
        User user = new User();
        user.setAge(18);
        user.setName("ZiChen");
        javaSerializaWithFile.serialize(user);

        Object deserialize = javaSerializaWithFile.deserialize(null, null);
        System.out.println(deserialize);
    }

}
