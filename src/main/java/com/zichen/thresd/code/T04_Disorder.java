package com.zichen.thresd.code;

/**
 * 测试jvm中是否会发生指令重排序
 */
public class T04_Disorder {
    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException{
        int i = 0;
        for(;;){
            i++;
            x = 0; y = 0;
            a = 0; b = 0;
            Thread one = new Thread(new Runnable(){
                @Override
                public void run(){
                    //由于栈线程one先启动，下面这句话让他等一等线程two，读者可根据自己电脑实际性能适当调整等待时间
                    //shortWait(100000);
                    a = 1;
                    x = b;
                }
            });
            Thread other = new Thread(new Runnable(){
                @Override
                public void run() {
                    b = 1;
                    y = a;
                }
            });
            one.start(); other.start();
            one.join(); other.join();
            String result = "第" + i + "次出现 (" + x + ", " + y + ")";
            if(x == 0 && y == 0){
                System.err.println(result);
                break;
            } else {
                //System.out.println(result);
            }
        }
    }
}
