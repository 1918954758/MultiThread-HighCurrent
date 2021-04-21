package com.lockpkg;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RWDictionary {
    private final Map<String, String> map = new TreeMap<>();
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();

    public String get(String key) {
        r.lock();
        try {
            System.out.println("read - " + Thread.currentThread().getName());
            return map.get(key);
        } finally {
            r.unlock();
        }
    }
    public String[] allKeys() {
        r.lock();
        try {
            return (String[]) map.keySet().toArray();
        } finally {
            r.unlock();
        }
    }
    public String put(String key, String value) {
        w.lock();
        try {
            System.out.println("write - " + Thread.currentThread().getName());
            return map.put(key, value);
        } finally {
            w.unlock();
        }
    }
    public void clear() {
        w.lock();
        try {
            map.clear();
        } finally {
            w.unlock();
        }
    }

    @Test
    public void test() {
        Thread t1_1 = new Thread(() -> put("name1", "zhangsan"));
        Thread t1_2 = new Thread(() -> put("name2", "lisi"));
        Thread t1_3 = new Thread(() -> put("name3", "wuwang"));
        Thread t1_4 = new Thread(() -> put("name4", "zhaoliu"));
        Thread t1_5 = new Thread(() -> put("name5", "tianqi"));

        Thread t2_1 = new Thread(() -> get("name1"));
        Thread t2_2 = new Thread(() -> get("name2"));
        Thread t2_3 = new Thread(() -> get("name3"));
        Thread t2_4 = new Thread(() -> get("name4"));
        Thread t2_5 = new Thread(() -> get("name5"));

        t1_1.start();
        t1_2.start();
        t1_3.start();
        t1_4.start();
        t1_5.start();

        t2_1.start();
        t2_2.start();
        t2_3.start();
        t2_4.start();
        t2_5.start();

        try {
            t1_1.join();
            t1_2.join();
            t1_3.join();
            t1_4.join();
            t1_5.join();

            t2_1.join();
            t2_2.join();
            t2_3.join();
            t2_4.join();
            t2_5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }

    {
        map.put("name1", "1");
        map.put("name2", "2");
        map.put("name3", "3");
        map.put("name4", "4");
        map.put("name5", "5");
    }
}
