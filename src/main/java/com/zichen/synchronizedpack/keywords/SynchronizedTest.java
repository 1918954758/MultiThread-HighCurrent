package com.zichen.synchronizedpack.keywords;


public class SynchronizedTest {
    static int val = 0;
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> count());
        Thread t2 = new Thread(() -> count());
        Thread t3 = new Thread(() -> count());
        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(val);
    }

    public static void count() {
        synchronized (SynchronizedTest.class) {
            for (int i = 0; i < 10000; i++) {
                val++;
            }
        }
        //类似
//        try {
//            MONITORENTER;
//            ...
//            MONITOREXIT;
//        } finally {
//            MONITOREXIT;
//        }
    }
}
