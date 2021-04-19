package com.current.T01_Atomic;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @name: AtomicIntegerTest
 * @description:
 * @author: zichen
 * @date: 2021/4/17  19:49
 */
public class T001_1_AtomicIntegerTest {

    private static Set<Integer> set = Collections.synchronizedSet(new HashSet<>());

    /*
     * 1. 保证线程之间可见性
     * 2. 阻止指令重排序
     * <p>
     * 3. 不能保证原子性
     * </p>
     */
    private static volatile int value = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            int x = 0;
            while (x < 5000) {
                set.add(value);
                int temp = value;
                System.out.println(Thread.currentThread().getName() + " : " + temp);
                value += 1;
                /**
                 * value = value + 1
                 * 1) get value from main memroy to local memory
                 * 2) exec add 1 => x
                 * 3) assign the value to x
                 * 4) flush to main memory
                 */
                x++;
            }
        });

        Thread t2 = new Thread(() -> {
            int x = 0;
            while (x < 5000) {
                set.add(value);
                int temp = value;
                System.out.println(Thread.currentThread().getName() + " : " + temp);
                value += 1;
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
        System.out.println("======================");
        System.out.println(set.size());
    }
}