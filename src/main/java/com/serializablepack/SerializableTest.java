package com.serializablepack;

import org.junit.Test;

/**
 * @name: SerializableTest
 * @description:
 * @author: zichen
 * @date: 2021/4/25  18:50
 */
public class SerializableTest {

    /**
     * 基于原生Serializable实现序列化测试
     */
    @Test
    public void test1() {
        ISerializable iSerializable = new JavaSerializaWithFile();
        User user = new User();
        user.setAge(18);
        user.setName("ZiChen");
        iSerializable.serialize(user);

        Object deserialize = iSerializable.deserialize(null, null);
        System.out.println(deserialize);
    }

    @Test
    public void test2() {
        ISerializable iSerializable = new XStreamSerializabler();
        User user = new User();
        user.setAge(25);
        user.setName("zichen");
        byte[] bytes = iSerializable.serialize(user);

        Object deserialize = iSerializable.deserialize(bytes, null);
        System.out.println(deserialize);
    }
}
