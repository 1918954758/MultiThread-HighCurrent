package com.current.T01_Atomic;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @name: T001_3_AtomicIntegerTest
 * @description:
 * @author: zichen
 * @date: 2021/4/18  11:20
 */
public class T001_3_AtomicIntegerTest {


    @Test
    public void testCreate_01() {
        /**
         * create
         */
        AtomicInteger i = new AtomicInteger();
        System.out.println(i.get());

        i = new AtomicInteger(10);
        System.out.println(i.get());

        i.set(12);
        System.out.println(i.get());

        i.lazySet(13);
        System.out.println(i.get());
    }

    @Test
    public void testCreate_02() {
        AtomicInteger getAddSet = new AtomicInteger(10);
        int result = getAddSet.getAndAdd(10);
        System.out.println(result);
        System.out.println(getAddSet.get());
    }

    @Test
    public void testGetAddSet() {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                int i1 = atomicInteger.getAndAdd(1);
                System.out.println(Thread.currentThread().getName() + " : " + i1);

            }

        }).start();

        for (int i = 0; i < 500; i++) {
            int i1 = atomicInteger.getAndAdd(1);
            System.out.println(Thread.currentThread().getName() + " : " + i1);

        }
        System.out.println(atomicInteger.get());
    }

    @Test
    public void testCompareAndSet() {
        AtomicInteger i = new AtomicInteger(10);
        boolean b1 = i.compareAndSet(12, 20);
        System.out.println(i.get());
        System.out.println(b1);
        System.out.println("====================");
        boolean b2 = i.compareAndSet(10, 20);
        System.out.println(i.get());
        System.out.println(b2);
    }
}
