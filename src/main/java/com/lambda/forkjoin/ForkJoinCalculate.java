package com.lambda.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * @name: ForkJoinCalculate
 * @description:
 * @author: zichen
 * @date: 2021/5/1  15:10
 */
public class ForkJoinCalculate extends RecursiveTask<Long> {

    private static final long serialVersionUID = -454647993125069179L;
    private long start;
    private long end;

    private static final long THERSHOLD = 10000;

    public ForkJoinCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;

        if (length <= THERSHOLD) {
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long middle = (start + end) / 2;
            ForkJoinCalculate left = new ForkJoinCalculate(start, middle);
            left.fork();//拆分子任务，同时，压入线程队列

            ForkJoinCalculate right = new ForkJoinCalculate(middle + 1, end);
            right.fork();

            return left.join() + right.join();
        }
    }
}
