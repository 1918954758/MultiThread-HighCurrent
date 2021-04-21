package com.zichen.synchronizedpack.synchronizedemo;

import org.openjdk.jol.info.ClassLayout;

/**
 * 轻量级锁和无锁
 */
public class S006_TurnToThreadLock_NullLockTest {

    public static void main(String[] args) {
        /**
         * 无锁
         */
        Object o = new Object();

        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        System.out.println("==================");

        //o.hashCode();

        /**
         * 轻量级锁
         */
        synchronized (o) {
            /**
             * 重量级锁
             */
            //o.hashCode();
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
