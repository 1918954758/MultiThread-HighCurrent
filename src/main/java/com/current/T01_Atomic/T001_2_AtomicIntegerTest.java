package com.current.T01_Atomic;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @name: T002_AtomicInteferTest
 * @description:
 * @author: zichen
 * @date: 2021/4/17  20:12
 */
public class T001_2_AtomicIntegerTest {

    public static Set<Integer> set = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) {
        AtomicInteger value = new AtomicInteger(1);

        Thread t1 = new Thread(() -> {
            int x = 0;
            while (x < 5000) {
                int v = value.getAndIncrement();
                set.add(v);
                System.out.println(Thread.currentThread().getName() + " : " + v);
                x++;
            }
        });

        Thread t2 = new Thread(() -> {
            int x = 0;
            while (x < 5000) {
                int v = value.getAndIncrement();;
                set.add(v);
                int temp = v;
                System.out.println(Thread.currentThread().getName() + " : " + v);
                x++;
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(set.size());
    }
}
