package com.zichen.synchronizedpack.keywords;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @name: CASTest
 * @description:
 * @author: zichen
 * @date: 2021/4/20  21:26
 */
public class CASTest {
    private static final long SIZE;
    private static Unsafe u;

    static {
        try {
            Field f = Unsafe.class.getDeclaredFields()[0];
            f.setAccessible(true);
            u = (Unsafe) f.get(Unsafe.class);
            SIZE = u.objectFieldOffset
                    (CASTest.class.getDeclaredField("size")); //获取字段在CasTest对象上的偏移量
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    private int size = 2;

    public void t() {
        System.out.println(size);
        if (u.compareAndSwapInt(this, SIZE, 2, 1))// 比较的是this内存上 偏移量为 SIZE，在这里实际就是指size。期望值是2，想改成1
            System.out.println(true);
        System.out.println(size);
        size = 3;
        if (u.compareAndSwapInt(this, SIZE, 3, 7)) // 实际修改size = 7，不是改的SIZE
            System.out.println(true);
        System.out.println(SIZE);
        System.out.println(size);
        System.out.println("====================");
        System.out.println(ClassLayout.parseInstance(u).toPrintable());
    }

    @Test
    public void test() {
        t();
    }
}
