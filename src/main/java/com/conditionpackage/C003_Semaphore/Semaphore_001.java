package com.conditionpackage.C003_Semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @name: Semaphore_001
 * @description:
 * @author: zichen
 * @date: 2021/4/24  15:38
 */
public class Semaphore_001 {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        for (int i = 1; i < 11; i++) {
            new Car(i, semaphore).start();
        }
    }

    static class Car extends Thread {
        private int num;
        private Semaphore semaphore;

        public Car(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();//获得一个令牌，如果获取不到令牌，则会阻塞
                System.out.println("第 " + num + " 抢占一个车位");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("第 " + num + " 开走咯");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
