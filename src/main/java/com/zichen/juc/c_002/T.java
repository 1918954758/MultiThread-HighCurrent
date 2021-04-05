package com.zichen.juc.c_002;

/**
 * 对某个对象加锁
 */
public class T {
    private int count = 0;

    public void m() {
        synchronized (this) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }
}
