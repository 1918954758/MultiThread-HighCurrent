package com.zichen.synchronizedpack.synchronizedemo;

import org.openjdk.jol.info.ClassLayout;

/**
 * 无锁
 */
public class S001_NullLockTest {
    public static void main(String[] args) {

        Object o = new Object();
        //o.hashCode();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}
