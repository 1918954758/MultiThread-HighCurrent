package com.lockpkg;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁
 * 拿到相同锁的线程，再次进入，记录重入次数，
 * 当该线程结束，减少重入次数，不然不能释放锁，其他线程阻塞
 */
public class ReentrantLockTest {
    static Lock lock = new ReentrantLock();
    @Test
    public void test() {
        Thread t1 = new Thread(() -> rtt1());
        Thread t2 = new Thread(() -> rtt1());
        Thread t3 = new Thread(() -> rtt1());
        Thread t4 = new Thread(() -> rtt1());
        Thread t5 = new Thread(() -> rtt1());
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void rtt1() {
        try {
            lock.lock();
            System.out.println("start sleep - rtt1 - " + Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(2);
            rtt2();
            System.out.println("end sleep - rtt1 - " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void rtt2() {

        try {
            lock.lock();
            System.out.println("start sleep - rtt2 - " + Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(2);
            rtt3();
            System.out.println("end sleep - rtt2 - " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void rtt3() {
        try {
            lock.lock();
            System.out.println("start sleep - rtt3 - " + Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(2);
            System.out.println("end sleep - rtt3 - " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
