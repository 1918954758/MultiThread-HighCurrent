package com.conditionpackage.C002_CountDownLatch;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @name: CountDownLatch_001
 * @description:
 * @author: zichen
 * @date: 2021/4/24  14:35
 */
public class CountDownLatch_001 extends Thread{

    @Test
    public void countDownLatchTest01() {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName() + " : " + countDownLatch.getCount());
            countDownLatch.countDown();
        }).start();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName() + " : " + countDownLatch.getCount());
            countDownLatch.countDown();
        }).start();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName() + " : " + countDownLatch.getCount());
            countDownLatch.countDown();
        }).start();

        try {
            countDownLatch.await();
            System.out.println(Thread.currentThread().getName() + " : start");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static CountDownLatch cdl = new CountDownLatch(1);
    static Set<String> set = new HashSet<>();

    @Test
    public void countDownLatch02() {
        for (int i = 0; i < 1000; i++) {
            new CountDownLatch_001().start();
        }
        cdl.countDown();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("set count is : " + set.size());
    }

    @Override
    public void run() {
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ThreadName : " + Thread.currentThread().getName());
        set.add(Thread.currentThread().getName());
    }
}
