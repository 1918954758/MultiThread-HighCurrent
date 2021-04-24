package com.zichen.thresd.code;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @name: YeildTest
 * @description:
 * @author: zichen
 * @date: 2021/4/24  14:03
 */
public class YeildTest {

    @Test
    public void yeildTest() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                A a = new A();
                a.a();
                while (true) {
                    System.out.println("Thread.yield() - start");
                    Thread.yield();
                    System.out.println("Thread.yield() - end");
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                B b = new B();
                b.b();
            }
        }).start();
    }

    class A {
        public void a() {
            System.out.println("执行 A.a()");
        }
    }
    class B{
        public void b() {
            System.out.println("执行 B.b()");
        }
    }
}
