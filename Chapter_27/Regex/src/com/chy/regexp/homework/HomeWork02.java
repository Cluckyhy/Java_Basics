package com.chy.regexp.homework;

public class HomeWork02 {
    public static void main(String[] args) {
        //要求验证是不是正数或小数
        //这个题要考虑正数和负数
        String content = "009.8989";

        String regStrZ = "^\\d+$";
        String regStrF = "^[-]+\\d+$";
        String regStrXZ = "^\\d+\\.\\d+$";
        String regStrXF = "^[-]+\\d+\\.\\d+$";

        String regStr = "^[-+]?([1-9]\\d*|0)(\\.\\d+)?$";

        if (content.matches(regStrZ)) {
            System.out.println("此数为一个正整数");
        } else if (content.matches(regStrXZ)) {
            System.out.println("此数为一个小数");
        } else if (content.matches(regStrF)) {
            System.out.println("此数为一个负数");
        } else if (content.matches(regStrXF)) {
            System.out.println("此数为一个负小数");
        }else{
            System.out.println("错误..不是一个数字");
        }
    }
}
