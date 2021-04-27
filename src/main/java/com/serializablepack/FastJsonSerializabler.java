package com.serializablepack;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONSerializable;
import com.alibaba.fastjson.serializer.JSONSerializer;

public class FastJsonSerializabler implements ISerializable {

    @Override
    public <T> byte[] serialize(T obj) {
       //return JSON.toJSONString(obj).getBytes();
       return JSON.toJSONBytes(obj);
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        return (T)JSON.parseObject(new String(data));
    }
}
