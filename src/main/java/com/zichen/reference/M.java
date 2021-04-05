package com.zichen.reference;

public class M {
    //当M被回收的时候，finalize()方法会被调用
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }
}
