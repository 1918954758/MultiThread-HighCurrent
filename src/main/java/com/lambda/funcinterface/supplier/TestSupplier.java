package com.lambda.funcinterface.supplier;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @name: TestSupplier
 * @description: 供给型
 * @author: zichen
 * @date: 2021/4/18  17:35
 */
public class TestSupplier {

    @Test
    public void test() {
        List<Integer> list = getNumList(10, () -> (int) (Math.random() * 100));
        System.out.println(list);
    }

    //产生一些数，并放入集合中
    public List<Integer> getNumList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            Integer n = sup.get();
            list.add(n);
        }
        return list;
    }
}
