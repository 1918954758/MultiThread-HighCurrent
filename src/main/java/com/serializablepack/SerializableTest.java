package com.serializablepack;

import com.alibaba.fastjson.serializer.SerializeWriter;
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
        System.out.println(new String(bytes));

        Object deserialize = iSerializable.deserialize(bytes, null);
        System.out.println(deserialize);
    }

    @Test
    public void test3() {
        /**
         * 使用FastJson序列化，writeObject和readObject配合transient修饰的变量，是不起作用的
         */
        ISerializable iSerializable = new FastJsonSerializabler();
        User user = new User();
        user.setAge(25);
        user.setName("zichen");
        byte[] serialize = iSerializable.serialize(user);
        System.out.println(serialize.length);

        Object deserialize = iSerializable.deserialize(serialize, User.class);
        System.out.println(deserialize);
    }

    @Test
    public void test4() {
        /**
         * 使用FastJson序列化，writeObject和readObject配合transient修饰的变量，是不起作用的
         */
        ISerializable iSerializable = new HessianSerializabler();
        User user = new User();
        user.setAge(25);
        user.setName("zichen");
        byte[] serialize = iSerializable.serialize(user);
        System.out.println("serialize.length = " + serialize.length);
        System.out.println("===============output binary code start =================");
        for (byte b : serialize) {
            System.out.println("serializable byte = " + Byte.toUnsignedInt(b));
        }
        System.out.println("===============output binary code end =================");
        System.out.println("toString = " + new String(serialize));

        Object deserialize = iSerializable.deserialize(serialize, null);
        System.out.println(deserialize);
    }
}
