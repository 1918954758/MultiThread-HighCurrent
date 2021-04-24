package com.conditionpackage.C001_Condition;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @name: ConditionTest
 * @description:
 * @author: zichen
 * @date: 2021/4/24  1:16
 */
public class ConditionTest {

    @Test
    public void conditionTest() {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        //new Thread(new ConditionNotify(lock, condition)).start();
        new Thread(new ConditionWait(lock, condition)).start();

        new Thread(new ConditionNotify__001(lock, condition)).start();
        new Thread(new ConditionNotify__002(lock, condition)).start();
        new Thread(new ConditionNotify__003(lock, condition)).start();
        new Thread(new ConditionNotify__004(lock, condition)).start();
        new Thread(new ConditionNotify__005(lock, condition)).start();
    }
}
