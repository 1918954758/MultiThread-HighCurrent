package com.zichen.juc.c_004;

/**
 * 对某个对象加锁
 */
public class T {
    private static int count = 10;

    //对一个static修饰的方法加锁，就相当于synchronized(T.class)
    public synchronized static void m() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void mm() {
        synchronized (T.class) {
            count--;
        }
    }
}
