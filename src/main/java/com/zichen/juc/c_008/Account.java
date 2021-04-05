package com.zichen.juc.c_008;

import java.util.concurrent.TimeUnit;

/**
 * 模拟银行账户
 * 对业务方法加锁和对业务方法不加锁
 * 这样写可否？
 */
public class Account {
    String name;
    double balane;

    public synchronized void set(String name, double balance) {
        this.name = name;
        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        this.balane = balance;
    }

    public synchronized double getBalane(String name) {
        return this.balane;
    }

    public static void main(String[] args) {
        Account a = new Account();
        new Thread(() -> a.set("zichen", 100.00)).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(a.getBalane("zichen"));
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("zichen");
    }
}
