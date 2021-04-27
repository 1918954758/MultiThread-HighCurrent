package com.serializablepack;

import java.beans.Transient;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @name: User
 * @description:
 * @author: zichen
 * @date: 2021/4/25  18:26
 */
public class User implements Serializable {


    private static final long serialVersionUID = -3835703195435436538L;

    private transient String name;
    private int age;

    /**
     * 和transient配合使用，可以序列transient修饰的变量
     */
    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeObject(name);
    }

    /**
     * 和transient配合使用，可以序列transient修饰的变量
     */
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        name = (String) s.readObject();
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
