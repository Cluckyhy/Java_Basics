package com.chy.enum_init;

public class EnumInit01 {
    public static void main(String[] args) {
        /*
        * 自定义枚举：
        * 不需要提供setXXX方法，因为枚举对象值通常为只读
        * 对枚举对象/属性使用final + static 共同修饰，实现底层优化
        * 枚举对象名通常使用大写，常量命名规范
        * 枚举对象根据需要，也可以有多个属性
        * */
        System.out.println(Season.SPRING);
        System.out.println(Season.AUTUMN);
    }
}

//演示自定义枚举实现
class Season{
    private String name;
    private String desc;

    //1、将构造器私有化，目的防止 直接new
    //2、去掉setXXX方法，防止属性被修改
    //3、在Season 内部，直接创建固定的对象
    //4、优化，可以加入 final 修饰符
    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    //定义了四个对象，固定
    public final static Season SPRING = new Season("春天","温暖");
    public final static Season SUMMER = new Season("夏天", "炎热");
    public final static Season AUTUMN = new Season("秋天", "凉爽");
    public final static Season WINTER = new Season("冬天", "寒冷");

    public String getName() {
        return name;
    }


    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
