package com.zichen.juc.c_010;

import java.util.concurrent.TimeUnit;

/**
 * 父子类，可重入
 */
public class T {
    //子类调用，所得仍然是子类对象
    synchronized void m() {//synchronized(this)
        System.out.println("m start...");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m end...");
    }

    public static void main(String[] args) {
        new TT().m();
    }
}

class TT extends T {
    //synchronized(this)，锁的是子类对象
    @Override
    synchronized void m() {
        System.out.println("child m start...");
        super.m();
        System.out.println("clild m end...");
    }
}
