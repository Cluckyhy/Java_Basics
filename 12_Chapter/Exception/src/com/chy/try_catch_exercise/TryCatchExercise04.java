package com.chy.try_catch_exercise;

import java.util.Scanner;

public class TryCatchExercise04 {
    public static void main(String[] args) {
        //如果用户输入的不是一个整数，就提示它反复的输入，直到输入一个整数为止
        //创建一个Scanner对象
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("请用户输入一个整数：");
            String str = scanner.next();
            try {
                int result = Integer.parseInt(str);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("您输入的不是一个数字，请重新输入：");
            }
        }
    }
}
