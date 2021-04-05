package com.zichen.reference;

import java.lang.ref.SoftReference;

public class T02_SoftReference {
    public static void main(String[] args) {
        //m 指向 堆中 SoftReference对象时强引用
        //SoftReference对象中海油一个byte数组，SoftReference对象指向byte数组的引用就是软引用
        SoftReference<byte[]> m = new SoftReference<>(new byte[1024 * 10]);
        //m = null;
        System.out.println(m.get());
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(m.get());

        //在分配一个数组，heap将装不下，这时候系统会垃圾回收，先回收一次，如果不够，会把软引用干掉
        byte[] b = new byte[1024 * 1024 * 15];

        System.out.println(m.get());
        System.out.println(m.get().hashCode());
        System.out.println(b.getClass().hashCode());
    }
}
