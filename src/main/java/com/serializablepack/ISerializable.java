package com.serializablepack;

import java.io.Serializable;

/**
 * @name: ISerializable
 * @description:
 * @author: zichen
 * @date: 2021/4/25  18:31
 */
public interface ISerializable {

    <T> byte[] serialize(T obj);

    <T> T deserialize(byte[] data, Class<T> clazz);
}
