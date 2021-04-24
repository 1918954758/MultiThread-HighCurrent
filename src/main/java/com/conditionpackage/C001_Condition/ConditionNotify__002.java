package com.conditionpackage.C001_Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @name: ConditionNotify
 * @description:
 * @author: zichen
 * @date: 2021/4/24  1:13
 */
public class ConditionNotify__002 implements Runnable {

    private Lock lock;
    private Condition condition;

    public ConditionNotify__002(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println("Condition - Notify_002 - start");
            condition.signal();// unpark阻塞状态的线程
            System.out.println("Condition - Notify_002 - end");
        } finally {
            lock.unlock();
        }
    }
}
