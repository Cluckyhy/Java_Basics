package com.chy.throws_.throws_detail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowsDetail01 {
    public static void main(String[] args) {
        /*
        1、对于编译异常，程序中必须处理，比如 try-finally 或者 throws
        2、对于运行时异常，程序中如果没有处理，默认就是throws的方法处理
        3、子类重写父类的方法时，对抛出的异常规定是：
            子类重写的方法所抛出的异常类型要么和父类抛出的异常一致，要么为父类抛出的异常类型的子类型
        4、在throws 过程中，如果方法 try-catch，就相当于处理异常，就可以不必throws
         */
    }

    public static void f1() {
        int n1 = 10;
        int n2 = 0;
        double res = n1 / n2;
    }

    public static void f2(){
        //这里大家思考问题，调用f3()是否报错
        //f3();     //ERROR
        //1、因为f3()方法抛出的是一个编译异常
        //2、即这时，就要去显式的处理f3()抛出的编译异常。因为编译型异常，没有默认处理机制
        //3、在f2()中，要么try-catch-finally，或者继续throws 这个编译异常
    }
    public static void f3() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("hello.txt");
    }

    public static void f4(){
        //请大家思考这里调用f5()会报错吗
        //f5();
        //1、在f4()中调用方法f5()是ok的
        //2、原因是f5()抛出的是运行异常
        //3、而java中，并不要求程序员显式的处理，有默认处理机制
    }

    public static void f5() throws ArithmeticException{

    }

}

class Father{
    public void method() throws RuntimeException{

    }
}
class Son extends Father{
    @Override
    public void method() throws NullPointerException /*Exception ERROR*/{

    }
}


