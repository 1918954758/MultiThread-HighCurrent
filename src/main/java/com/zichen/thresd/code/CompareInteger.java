package com.zichen.thresd.code;

/**
 * 比较位运算和普通运算速度
 */
public class CompareInteger {
    public void sum1(int a, int b){
        System.out.println("a =  "  + a + ";  b  = " + b);
        long start = System.nanoTime();
        int temp = a;
        a = b;
        b = temp;
        System.out.println("普通计算：" + (System.nanoTime() - start) + "ns");
        System.out.println("a =  "  + a + ";  b  = " + b);
    }

    public void sum2(int a, int b){
        System.out.println("a =  "  + a + ";  b  = " + b);
        long start = System.nanoTime();
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("位计算：" + (System.nanoTime() - start) + "ns");
        System.out.println("a =  "  + a + ";  b  = " + b);
    }

    public static void main(String[] args) {
        CompareInteger  d = new CompareInteger();
        d.sum1(3,  4);

        System.out.println("==================");

        d.sum2(3, 4);
    }
}
