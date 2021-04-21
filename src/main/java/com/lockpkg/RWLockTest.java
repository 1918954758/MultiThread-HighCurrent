package com.lockpkg;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 重入读写锁
 * 下面分情况测试读写线程阻塞情况
 */
public class RWLockTest {

    static ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();


    /**
     * 两个线程读，不会阻塞
     */
    @Test
    public void testRR(){

        Thread t1 = new Thread(() -> rr1());
        Thread t2 = new Thread(() -> rr1());
        Thread t3 = new Thread(() -> rr1());
        Thread t4 = new Thread(() -> rr1());
        Thread t5 = new Thread(() -> rr1());

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

    public void rr1() {
        rwlock.readLock().lock();
        try {
            System.out.println("start sleep - rr1 - " + Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(2);
            System.out.println("end sleep - rr1 - " + Thread.currentThread().getName());
        }catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwlock.readLock().unlock();
        }
    }

    /**
     * 两个线程,写线程和写线程，会阻塞
     */
    @Test
    public void testWW(){
        Thread t1 = new Thread(() -> ww1());
        Thread t2 = new Thread(() -> ww1());
        Thread t3 = new Thread(() -> ww1());
        Thread t4 = new Thread(() -> ww1());
        Thread t5 = new Thread(() -> ww1());

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

    public void ww1() {
        rwlock.writeLock().lock();
        try {
            System.out.println("start sleep - ww1 - " + Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(3);
            System.out.println("end sleep - ww1 - " + Thread.currentThread().getName());
        }catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwlock.writeLock().unlock();
        }
    }


    int count = 0;
    /**
     * 两个线程,读线程和写线程，会阻塞
     */
    @Test
    public void testRW(){
        Thread t11 = new Thread(() -> w1());
        Thread t12 = new Thread(() -> r1());
        Thread t21 = new Thread(() -> w1());
        Thread t22 = new Thread(() -> r1());
        Thread t31 = new Thread(() -> w1());
        Thread t32 = new Thread(() -> r1());
        Thread t41 = new Thread(() -> w1());
        Thread t42 = new Thread(() -> r1());
        Thread t51 = new Thread(() -> w1());
        Thread t52 = new Thread(() -> r1());

        t11.start();
        t12.start();
        t21.start();
        t22.start();
        t31.start();
        t32.start();
        t41.start();
        t42.start();
        t51.start();
        t52.start();
        try {
            t11.join();
            t12.join();
            t21.join();
            t22.join();
            t31.join();
            t32.join();
            t41.join();
            t42.join();
            t51.join();
            t52.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void w1() {
        rwlock.writeLock().lock();
        try {
            System.out.println("start sleep - w1 - " + Thread.currentThread().getName());
            count++;
            TimeUnit.SECONDS.sleep(3);
            System.out.println("end sleep - w1 - " + Thread.currentThread().getName());
        }catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwlock.writeLock().unlock();
        }
    }

    public void r1() {
        rwlock.readLock().lock();
        try {
            System.out.println("start sleep - r1 - " + Thread.currentThread().getName());
            System.out.println("count = " + count);
            TimeUnit.SECONDS.sleep(3);
            System.out.println("end sleep - r1 - " + Thread.currentThread().getName());
        }catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwlock.readLock().unlock();
        }
    }
}
