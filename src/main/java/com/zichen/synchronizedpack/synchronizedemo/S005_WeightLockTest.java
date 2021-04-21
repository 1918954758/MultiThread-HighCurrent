package com.zichen.synchronizedpack.synchronizedemo;

import org.openjdk.jol.info.ClassLayout;

/**
 * 重量级锁
 */
public class S005_WeightLockTest {
    public static void main(String[] args) {
        Object o = new Object();

        /**
         * 重量级锁
         */
        synchronized (o) {
            o.hashCode();
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
