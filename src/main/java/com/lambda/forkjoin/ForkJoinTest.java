package com.lambda.forkjoin;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @name: ForkJoinTest
 * @description:
 * @author: zichen
 * @date: 2021/5/1  15:18
 */
public class ForkJoinTest {

    @Test
    public void test1() {
        Instant start = Instant.now();

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCalculate(0, 100000000000L);
        Long sum  = forkJoinPool.invoke(task);
        System.out.println(sum);

        Instant end = Instant.now();
        System.out.println("耗费时间 " + Duration.between(start, end).toMillis() + " 毫秒");
        //21977 毫秒
    }


    @Test
    public void test2() {
        Instant start = Instant.now();
        long sum = 0L;
        for (long i = 0; i <= 100000000000L; i++) {
            sum += i;
        }
        System.out.println(sum);

        Instant end = Instant.now();
        System.out.println("耗费时间 " + Duration.between(start, end).toMillis() + " 毫秒");
        //26307 毫秒
    }

    @Test
    public void test3() {
        Instant start = Instant.now();
        long reduce = LongStream.rangeClosed(0, 100000000000L)
                .parallel()
                .reduce(0, Long::sum);
        System.out.println(reduce);
        Instant end = Instant.now();
        System.out.println("耗费时间 " + Duration.between(start, end).toMillis() + " 毫秒");
        //14587 毫秒
    }
}
