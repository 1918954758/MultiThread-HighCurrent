package com.conditionpackage.WaitNotifyTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @name: WaitDemo
 * @description:
 * @author: zichen
 * @date: 2021/4/24  22:05
 */
public class WaitDemo implements Runnable{

    private Object object;

    public WaitDemo(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        synchronized(object) {
            try {
                System.out.println("Wait - start");
                object.wait();
                System.out.println("Wait - end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
