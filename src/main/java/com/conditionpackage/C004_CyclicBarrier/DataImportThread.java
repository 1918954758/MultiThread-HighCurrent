package com.conditionpackage.C004_CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @name: DataImportThread
 * @description:
 * @author: zichen
 * @date: 2021/4/24  16:19
 */
public class DataImportThread extends Thread{

    private CyclicBarrier cyclicBarrier;
    private String path;

    public DataImportThread(CyclicBarrier cyclicBarrier, String path) {
        this.cyclicBarrier = cyclicBarrier;
        this.path = path;
    }

    @Override
    public void run() {
        System.out.println("开始导入： " + path + "数据");
        //TODO
        try {
            cyclicBarrier.await();//阻塞
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
