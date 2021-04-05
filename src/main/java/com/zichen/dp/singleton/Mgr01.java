package com.zichen.dp.singleton;

/**
 * singleton
 * 单例模式：饿汉模式
 * 缺点：不管用到与否，类加载时就完成实例化
 * Class.forName("");
 * 如果不用，就是浪费资源
 */
public class Mgr01 {
    //new instance
    private static final Mgr01 INSTANCE = new Mgr01();

    //structure is private, can't new Mgr01
    //promise one instance
    private Mgr01(){

    }

    //getInstance
    public static Mgr01 getInstance(){
        return INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    //two instance are equal.
    public static void main(String[] args){
        Mgr01 m1 = Mgr01.getInstance();
        Mgr01 m2 = Mgr01.getInstance();
        System.out.println(m1 == m2);
    }
}
