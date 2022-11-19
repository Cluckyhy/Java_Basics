package com.chy.enum_;

public class EnumExercise02 {
    public static void main(String[] args) {
        WEEK[] week = WEEK.values();
        System.out.println("所有星期的信息如下：");
        for (WEEK week1 : week) {
            System.out.println(week1);
        }
    }
}

enum WEEK{
    MONDAY("星期一"),TUESDAY("星期二"),WEDNESDAY("星期三"),THURSDAY("星期四"),FRIDAY("星期五"),SATURDAY("星期六"),SUNDAY("星期日");
    private String name;

    WEEK(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
