package com.zichen.synchronizedpack.synchronizedemo;

import org.openjdk.jol.info.ClassLayout;

/**
 * 轻量级锁
 */
public class S004_LightWeightLockTest {
    public static void main(String[] args) {
        Object o = new Object();
        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
