package com.zichen.synchronizedpack.synchronizedemo;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * 延迟偏向锁
 * jdk1.8：
 *      延迟小于5秒，无锁
 *      延迟大于等于5秒，延迟偏向锁
 */
public class S002_LayoutTurnToThreadLockTest {
    public static void main(String[] args) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}
