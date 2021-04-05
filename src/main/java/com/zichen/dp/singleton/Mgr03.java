package com.zichen.dp.singleton;

/**
 * lazy loading
 * 也称 懒汉模式：加锁，不管有多少个县城，都能保证只有一个实例
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 *
 * 加两个if判断的模式，称为双重检查单例
 */
public class Mgr03 {
    /*
     *
     */
    private static volatile Mgr03 INSTANCE;

    private Mgr03(){

    }

    public static /*synchronized*/ Mgr03 getInstance(){
        //业务代码
        if (INSTANCE == null) {
            synchronized (Mgr03.class) {
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Mgr03();
                }
            }
        }
        return INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++){
            new Thread(() -> {
                System.out.println(Mgr03.getInstance().hashCode());
            }).start();
        }
    }
}
