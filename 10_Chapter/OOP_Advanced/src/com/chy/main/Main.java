package com.chy.main;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("第" + (i + 1) + "个参数： " + args[i]);
        }
        System.out.println("总参数个数：" + args.length);
    }
}
