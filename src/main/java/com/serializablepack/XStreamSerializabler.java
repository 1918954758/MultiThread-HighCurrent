package com.serializablepack;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.nio.charset.StandardCharsets;

public class XStreamSerializabler implements ISerializable{

    final XStream xStream = new XStream(new DomDriver());
    @Override
    public <T> byte[] serialize(T obj) {
        String s = xStream.toXML(obj);
        return s.getBytes();
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        Object o = xStream.fromXML(new String(data));
        return (T) o;
    }
}
