package com.zichen.synchronizedpack.synchronizedemo;

import org.openjdk.jol.info.ClassLayout;

public class ObjectStruckTest {

    public static void main(String[] args) {
        TestClass t = new TestClass();

        char a = 'a';

        System.out.println(a);
        System.out.println(ClassLayout.parseInstance(t).toPrintable());
    }
}
