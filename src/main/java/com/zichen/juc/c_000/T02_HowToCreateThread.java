package com.zichen.juc.c_000;

/**
 * How to create Thread?
 */
public class T02_HowToCreateThread {
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello MyRun");
        }
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello Runnable");
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
        new Thread(new MyRunnable()).start();
        new Thread(() -> {
            System.out.println("Hello Lambda!");
        }).start();
    }
}
