package com.conditionpackage.WaitNotifyTest;

import org.junit.Test;

/**
 * @name: Test
 * @description:
 * @author: zichen
 * @date: 2021/4/24  22:09
 */
public class WaitAndNotifyTest {

    @Test
    public void test() {
        Object object = new Object();

        new Thread(new WaitDemo(object)).start();
        new Thread(new NotifyDemo(object)).start();
    }
}
