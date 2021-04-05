package com.zichen.thresd.code.binary;

public class Demo02 {
    public static void main(String[] args) {
        int a = 3;
        int b = 4;
        Demo02 d = new Demo02();
        System.out.println("start");
        d.swap1(a, b);
        System.out.println("===========");
        d.swap2(a, b);
        System.out.println("===========");
    }

    private void swap1(int a, int b) {
        long start = System.nanoTime();
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("执行异或运算，" + (System.nanoTime() - start) + "ns");
        System.out.println("a = " + a + "; b = " + b);
    }

    private void swap2(int a, int b) {
        long start = System.nanoTime();
        int temp = a;
        a = b;
        b = temp;
        System.out.println("执行零时变量运算，" + (System.nanoTime() - start) + "ns");
        System.out.println("a = " + a + "; b = " + b);
    }

}
