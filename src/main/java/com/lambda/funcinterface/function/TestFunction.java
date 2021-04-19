package com.lambda.funcinterface.function;

import org.junit.Test;

import java.util.Locale;
import java.util.function.Function;

/**
 * @name: TestFunction
 * @description: 函数型
 * @author: zichen
 * @date: 2021/4/18  17:34
 */
public class TestFunction {

    @Test
    public void test() {
        String newStr = strHandler("abcdsetfFedf", (str) -> str.toUpperCase());
        System.out.println(newStr);
    }

    //用于处理字符串
    public String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

}
