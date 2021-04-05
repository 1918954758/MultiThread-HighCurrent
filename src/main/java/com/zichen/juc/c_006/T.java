package com.zichen.juc.c_006;

import java.util.concurrent.locks.Lock;

/**
 * @class： T
 * @description： 实现Runnable接口，多个线程操作一个变量
 * @author： zichen
 * @date： 2021/4/5  15:21
 * @version： 1.0
 */
public class T implements Runnable{

    private int count = 10;

    @Override
    public /*synchronized*/ void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            T t = new T();
            new Thread(t, "THREAD" + i).start();
        }
    }
}
