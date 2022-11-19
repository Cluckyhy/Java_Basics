package com.chy.enum_init;

public class EnumInit02 {
    public static void main(String[] args) {
        /*
        * 使用enum关键字实现枚举
        *   1、当我们使用enum关键字开发一个枚举类时，默认会继承Enum类，而且是一个final类
        *   2、传统的public static final Season02 SPRING = new Season02("春天","温暖");
        *       简写成SPRING("春天","温暖")这里必须知道，它调用的是哪个构造器
        *   3、如果使用无参构造器创建枚举对象，则实参列表和小括号都可以省略
        *   4、当有多个枚举对象时，使用，间隔，最后有一个分号结尾
        *   5、枚举对象必须放在枚举类的行首
        * */

        System.out.println(Season02.SPRING);
        System.out.println(Season02.AUTUMN);
    }
}

//演示使用enum关键字实现枚举
enum Season02{

    //定义了四个对象，固定
    //public final static Season02 SPRING = new Season02("春天","温暖");
    //public final static Season02 SUMMER = new Season02("夏天", "炎热");
    //public final static Season02 AUTUMN = new Season02("秋天", "凉爽");
    //public final static Season02 WINTER = new Season02("冬天", "寒冷");

    //如果使用了enum 来实现枚举类
    //1、使用关键字enum  替代  class
    //2、public final static Season02 SPRING = new Season02("春天","温暖");
    //替换为：SPRING("春天","温暖");     常量名(实参列表)
    //3、如果有多个常量(对象)，使用，号间隔即可
    //4、如果使用enum 来实现枚举，要求将定义的常量对象，必须写在最前面
    //5、如果我们使用的是无参构造器，创建常量对象，则可以省略()
    SPRING("春天","温暖"),SUMMER("夏天", "炎热"),AUTUMN("秋天", "凉爽"),WINTER("冬天", "寒冷"),WHAT;
    //SUMMER("夏天", "炎热");

    private String name;
    private String desc;

    private Season02(){

    }

    private Season02(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }


    public String getDesc() {
        return desc;
    }

    //@Override
    //public String toString() {
    //    return "Season{" +
    //            "name='" + name + '\'' +
    //            ", desc='" + desc + '\'' +
    //            '}';
    //}
}
