package com.zichen.juc.c_003;

/**
 *
 */
public class T {
    private int count = 10;

    //等同于 synchronized(this)
    public synchronized void m() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }
}
