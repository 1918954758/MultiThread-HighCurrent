package com.serializablepack;

import java.beans.Transient;
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
