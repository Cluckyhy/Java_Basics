package com.chy.static_;

public class StaticMethod {
    public static void main(String[] args) {
        //创建2个学生对象，交学费
        Stu tom = new Stu("tom");
        //tom.payFee(100);
        Stu.payFee(100);

        Stu mary = new Stu("mary");
        //mary.payFee(200);
        Stu.payFee(200);

        //输出当前收到的总学费
        Stu.showFee();

        //如果我们希望不创建对象实例，也可以调用某个方法(即当做工具来使用)
        //这时，把方法做成静态方法是非常合适的
    }
}

class Stu {
    private String name;//普通成员
    public int age;

    //定义一个静态变量
    private static double fee = 0;

    public Stu(String name) {
        this.name = name;
    }

    //普通成员方法，既可以访问静态成员，也可以访问静态成员
    public void test(){
        System.out.println(Stu.fee);
    }

    //说明：
    //1、当方法使用了static修饰后，该方法就是一个静态方法
    //2、静态方法就可以访问静态属性/变量
    //3、静态方法只能访问本类的静态成员(属性/方法)
    //4、静态方法中没有this的参数
    //5、类方法中不允许使用和对象有关的关键字
    //   比如this和super。普通方法(成员方法)可以
    public static void payFee(double fee) {
        Stu.fee += fee;//累积到静态变量中
        //报错，在静态方法中，是不能访问非静态成员的，即使是在本类或则public修饰的属性
        //System.out.println(age);
        //报错，在静态方法中，是不能访问非静态成员方法的
        //test();
        //System.out.println(this.age);
        //Stu chy = new Stu("chy");
        //System.out.println(chy.name);
    }

    public static void showFee() {
        System.out.println("总学费为：" + Stu.fee);
    }
}
