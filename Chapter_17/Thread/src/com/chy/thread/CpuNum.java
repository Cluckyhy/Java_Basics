package com.chy.thread;

public class CpuNum {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        //获取当前电脑的CPU数量/8核
        int CpuNum = runtime.availableProcessors();
        System.out.println("当前CPU的个数为：" + CpuNum);
    }
}
