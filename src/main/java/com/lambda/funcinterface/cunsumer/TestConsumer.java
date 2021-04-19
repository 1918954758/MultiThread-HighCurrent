package com.lambda.funcinterface.cunsumer;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * @name: TestConsumer
 * @description: 消费型
 * @author: zichen
 * @date: 2021/4/18  17:30
 */
public class TestConsumer {

    @Test
    public void test1() {
        happy(10000, (x) -> System.out.println("xxx消费" + x + "元"));
    }

    public void happy(double money, Consumer<Double> con){
        con.accept(money);
    }
}
