package com.zichen.thresd.code.binary;

public class Demo01 {
    public static void main(String[] args) {
        long start1 = System.nanoTime();
        int result1 = jisuan1();
        System.out.println("执行" + (System.nanoTime() - start1) + "纳秒之后，结果是：" + result1);

        System.out.println("=============================================");

        long start2 = System.nanoTime();
        int result2 = jisuan2();
        System.out.println("执行" + (System.nanoTime() - start2) + "纳秒之后，结果是：" + result2);
    }

    private static int jisuan2() {
        return 2 << 2;
    }

    private static int jisuan1() {
        return 2 * 2 * 2;
    }
}
