package com.conditionpackage.WaitNotifyTest;

/**
 * @name: NotifyDemo
 * @description:
 * @author: zichen
 * @date: 2021/4/24  22:08
 */
public class NotifyDemo implements Runnable {

    private Object object;

    public NotifyDemo(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (object) {
            System.out.println("Notify - start");
            object.notify();
            System.out.println("Notify - end");
        }
    }
}
