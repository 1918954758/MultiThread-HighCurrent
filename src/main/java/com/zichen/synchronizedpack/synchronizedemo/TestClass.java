package com.zichen.synchronizedpack.synchronizedemo;

public class TestClass {
    private int i;//4byte
    private float f;//8byte
    private int[] arr= {1, 2, 3, 4, 3, 6, 5, 5, 6, 7};

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public float getF() {
        return f;
    }

    public void setF(float f) {
        this.f = f;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }
}
