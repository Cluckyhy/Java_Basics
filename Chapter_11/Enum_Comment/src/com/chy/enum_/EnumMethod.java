package com.chy.enum_;

/*
 * 演示Enum类的各种方法使用
 * */
public class EnumMethod {
    public static void main(String[] args) {
        //使用Season02枚举类，来演示各种方法
        Season02 autumn = Season02.AUTUMN;
        //输出枚举对象的名字
        System.out.println(autumn.name());

        //ordinal()输出的是该枚举对象的次序/编号
        //AUTUMN 枚举对象是第三个，因此输出2
        System.out.println(autumn.ordinal());

        //从反编译可以看出 values方法，返回Season02[]
        //含有定义的所有枚举对象
        Season02[] values = Season02.values();
        System.out.println("-------遍历取出枚举对象(增强for循环--------");
        for (Season02 value : values) {
            System.out.println(value);
        }

        //valueOf：将字符串转换成枚举对象，要求字符串必须为已有的常量名，否则报异常
        //1、根据你输入的"AUTUMN"到Season02的枚举对象去查找
        //2、如果找到了，就返回，如果没有找到，就报错
        Season02 autumn1 = Season02.valueOf("AUTUMN");
        System.out.println("autumn1 = " + autumn1);
        System.out.println(autumn == autumn1);

        //compareTo：比较两个枚举常量，比较的就是编号
        //1、就是把 Season02.AUTUMN 枚举对象的编号 和 Season02.SUMMER枚举对象的编号比较
        //2、返回 Season02.AUTUMN 的编号[2] - Season02.SUMMER 的编号[1]  = 1
        System.out.println(Season02.AUTUMN.compareTo(Season02.SUMMER));

        //补充了增强for循环
        //int[] nums = {1,4,54};
        ////普通for循环
        //System.out.println("-----------普通for循环-----------");
        //for (int i = 0; i < nums.length; i++) {
        //    System.out.println(nums[i]);
        //}
        //
        ////增强for循环
        //System.out.println("-----------增强for循环-----------");
        ////执行流程是：依次从nums数组中取出数据，赋给i，如果取出完毕，则退出for
        //for (int num : nums) {
        //    System.out.println(num);
        //}
    }
}

enum Season02 {

    SPRING("春天", "温暖"), SUMMER("夏天", "炎热"), AUTUMN("秋天", "凉爽"), WINTER("冬天", "寒冷");
    //SUMMER("夏天", "炎热");

    private String name;
    private String desc;

    private Season02() {

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
}