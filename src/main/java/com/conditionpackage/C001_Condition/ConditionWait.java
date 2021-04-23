package com.conditionpackage.C001_Condition;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @name: ConditionWait
 * @description:
 * @author: zichen
 * @date: 2021/4/24  1:14
 */
public class ConditionWait implements Runnable {

    private Lock lock;
    private Condition condition;

    public ConditionWait(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            try {
                System.out.println("Condition - Wait - start");
                //condition.await();
                condition.await(5, TimeUnit.SECONDS);
                System.out.println("Condition - Wait - end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlock();
        }
    }
}
