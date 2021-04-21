package com.zichen.synchronizedpack.synchronizedemo;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * 延迟偏向锁和偏向锁
 */
public class S007_LayoutTurnToThreadLock_TurnToThreadTest {
    public static void main(String[] args) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Object o = new Object();
        //延迟偏向锁
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        //上面支持延迟偏向锁，下面就升级为偏向锁

        synchronized (o) {
            //偏向锁
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }

    @Test
    public void lightWeightLockTest() {

        //上面没有延迟偏向锁，jvm认为不支持偏向锁，所以直接升级为轻量级锁

        Object o = new Object();

        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
