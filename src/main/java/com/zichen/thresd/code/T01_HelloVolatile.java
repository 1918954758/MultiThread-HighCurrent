package com.zichen.thresd.code;

import java.util.concurrent.TimeUnit;

/**
 * 测试volatile关键字的可见性
 */
public class T01_HelloVolatile {
    volatile boolean running = true;
    //int i = 0;
    void m(){
        System.out.println("m start");
        while(running){
            //System.out.println(i++);
        }
        System.out.println("m end!");
    }

    public static void main(String[] args) {
        T01_HelloVolatile t = new T01_HelloVolatile();
        new Thread(t::m, "t1").start();

        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        t.running = false;
    }
}
