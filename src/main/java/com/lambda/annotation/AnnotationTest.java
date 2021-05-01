package com.lambda.annotation;

import org.junit.Test;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;

/**
 * @name: AnnotationTest
 * @description: jdk1.8  重复注解 与 类型注解
 * @author: zichen
 * @date: 2021/5/1  16:07
 */
public class AnnotationTest {

    @Test
    public void test1() throws NoSuchMethodException {
        Class<AnnotationTest> clazz = AnnotationTest.class;
        Method m1 = clazz.getMethod("show");
        MyAnnotation[] annotationsByType = m1.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation myAnnotation : annotationsByType) {
            System.out.println(myAnnotation.value());
        }
    }

    @MyAnnotation("Hello")
    @MyAnnotation("World")
    public void show(@MyAnnotation("abc") String str) {
    }

}
