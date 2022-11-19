package com.chy.enum_;

/*
枚举对应的英文：enumeration，简写：enum
枚举是一组常量的集合
可以理解为：枚举属于一种特殊的类，里面只包含一组有限的特定的对象
 */

public class Enumeration01 {
    public static void main(String[] args) {
        //使用
        Season sprint = new Season("春天","温暖");
        Season summer = new Season("夏天", "炎热");
        Season autumn = new Season("秋天", "凉爽");
        Season winter = new Season("冬天", "寒冷");
        //因为对于季节而言，它的对象(固定的4个)
        //这样的设计类的思路，不能体现季节是固定的四个对象
        //因此，这样的设计不好 ===> 枚举类[枚：一个一个 举：列举，即把具体的对象一个一个列举出来的类，就称为枚举类]
        Season other = new Season("红天", "....");

    }
}

class Season{
    private String name;
    private String desc;

    public Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
