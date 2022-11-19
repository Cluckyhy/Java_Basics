package com.chy.final_;

public class FinalDetail02 {
    public static void main(String[] args) {
        /*
        *  5、一般来说，如果一个类已经是final类了，就没有必要再将方法修饰成final方法了
        *  6、final不能修饰构造方法
        *  7、final 和 static 往往搭配使用，效率会更高，不会导致类加载，底层编译器做了优化处理
        *  8、包装类，(Integer,Double,Float,Boolean,String等都是final类)不能被继承的
        * */

        //如果一个静态属性被final修饰，就不会导致类的加载，效率更高
        //下面代码就不会输出：BBB 静态代码块被执行
        System.out.println(BBB.num);
    }
}


final class AAA{
    //一般来说，如果一个类已经是final类了，就没有必要再将方法修饰成final方法了
    //因为，类已经是final，就不能被其他类继承，继承都不能继承，更不可能重写方法了
    //public final void cry(){}
}

class BBB{
    public final static int num = 1000;
    static{
        System.out.println("BBB 静态代码块被执行");
    }
}
