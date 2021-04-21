package com.zichen.synchronizedpack.synchronizedemo;

import org.openjdk.jol.info.ClassLayout;

import java.util.Arrays;

public class ArrayStruckTest {

    public static void main(String[] args) {
        int[] i = new int[5];

        i[0] = 1;
        i[1] = 2;
        i[2] = 3;
        System.out.println(Arrays.toString(i));

        System.out.println(ClassLayout.parseInstance(i).toPrintable());
    }
}
