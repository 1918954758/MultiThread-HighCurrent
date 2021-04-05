package com.zichen.reference;

import java.io.IOException;

/**
 * 强引用，也叫普通引用
 */
public class T01_NormalReference {
    public static void main(String[] args) throws IOException {
        //栈中的m指向堆里面的M，这个引用就叫强引用
        M m = new M();

        m = null;
        //当没有任何引用指向M的时候，此时才会被GC回收
        System.gc();//DisableExplicitGC

        System.in.read();
    }
}
