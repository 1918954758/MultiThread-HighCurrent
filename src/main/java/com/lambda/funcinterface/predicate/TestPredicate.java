package com.lambda.funcinterface.predicate;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @name: TestPredicate
 * @description: 断言型
 * @author: zichen
 * @date: 2021/4/18  17:34
 */
public class TestPredicate {

    @Test
    public void test() {
        boolean b = predicateTest(101010, (x) -> x > 1010);
        System.out.println(b);

        System.out.println("==================");

        List<String> list = Arrays.asList("hello", "badd", "lambda", "www", "ok");

        List<String> strings = filterStr(list, (s) -> s.length() > 3);
        System.out.println(strings);
    }

    //判断一个数字是否大于另一个数字
    public boolean predicateTest(Integer integer, Predicate<Integer> pre) {
        return pre.test(integer);
    }

    //将满足条件的字符串放入到集合返回
    public List<String> filterStr(List<String> list, Predicate<String> pre) {
        List<String> strList = new ArrayList<>();
        for (String str : list) {
            strList.add(str);
        }
        return strList;
    }
}
