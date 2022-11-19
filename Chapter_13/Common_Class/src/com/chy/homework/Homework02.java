package com.chy.homework;

import java.util.Scanner;

public class Homework02 {
    public static void main(String[] args) {
        //创建一个Scanner对象，用于用户输入信息
        Scanner scanner = new Scanner(System.in);
        //用户输入用户名：
        try {
            System.out.println("请用户输入姓名：");
            String name = scanner.next();
            if (!(name.length() > 1 && name.length() < 5)) {
                throw new RuntimeException("用户名长度不正确！！");
            }
            //用户输入密码：
            System.out.println("请用户输入密码：");
            String password = scanner.next();
            //int num = Integer.parseInt(password);
            //boolean isDigital;
            //if (num >= 0) {
            //    isDigital = true;
            //} else {
            //    isDigital = false;
            //}
            if (!(password.length() == 6 && isDigital(password))) {
                throw new RuntimeException("密码不符合要求！！");
            }
            //用户输入邮箱：
            System.out.println("请用户输入邮箱：");
            String email = scanner.next();
            int index1 = email.indexOf("@");
            int index2 = email.indexOf(".");
            if (!(index1 > 0 && index2 > 0 && index1 < index2)) {
                throw new RuntimeException("邮箱不符合要求！！");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("用户注册成功！！");
    }

    public static boolean isDigital(String str){
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                return false;
            }
        }
        return true;
    }
}
