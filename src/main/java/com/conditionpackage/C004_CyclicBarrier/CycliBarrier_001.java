package com.conditionpackage.C004_CyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * @name: CycliBarrier_001
 * @description:
 * @author: zichen
 * @date: 2021/4/24  16:21
 */
public class CycliBarrier_001 extends Thread{

    @Override
    public void run() {
        System.out.println("开始进行数据分析");
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new CycliBarrier_001());
        new Thread(new DataImportThread(cyclicBarrier, "file1")).start();
        new Thread(new DataImportThread(cyclicBarrier, "file2")).start();
        new Thread(new DataImportThread(cyclicBarrier, "file3")).start();
    }
}
