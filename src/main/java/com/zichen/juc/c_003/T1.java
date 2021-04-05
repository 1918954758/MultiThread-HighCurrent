package com.zichen.juc.c_003;

/**
 * 对某个对象加锁
 */
public class T1 {
    private int count = 10;

    public synchronized void m() {
        count--;
        System.out.println(Thread.currentThread().getName() + " coutn = " + count);
    }

    public void n() {
        count++;
    }
}
