package com.zichen.synchronizedpack.synchronizedemo;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * 偏向锁
 */
public class S003_TurnToThreadLockTest {
    public static void main(String[] args) {

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Object o = new Object();

        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }

    /**
     * 轻量级锁
     */
    @Test
    public void lightWeightLockTest() {
        Object o = new Object();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
