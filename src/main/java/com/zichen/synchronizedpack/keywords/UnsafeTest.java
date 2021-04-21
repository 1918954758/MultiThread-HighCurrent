package com.zichen.synchronizedpack.keywords;

import org.openjdk.jol.info.ClassLayout;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Unsafe
 * 需要使用
 */
public class UnsafeTest {
    public static void main(String[] args) throws Exception{
        Object o = new Object();
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);

        //unsafe.monitorEnter(o);
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        //unsafe.monitorExit(o);
    }
}
