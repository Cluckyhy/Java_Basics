package com.chy.throws_;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Throws01 {
    public static void main(String[] args) {
        //try_catch_finally 和 throws 两种二选一
        /*
            如果没有显示的使用try_catch机制和throws机制，默认是使用throws
            将发生的异常抛出，交给调用者(方法)处理，最顶级的处理者就是JVM
         */
    }

    public void f2() throws FileNotFoundException,NullPointerException,ArithmeticException {
        //创建一个文件流对象
        //1、这里的异常是一个FileNotFoundException编译异常
        //2、使用前面讲过的 try_catch_finally
        //3、使用throws，抛出异常，让调用f1方法的调用者(方法)处理
        //4、throws后面的异常类型可以是方法中产生的异常类型，也可以是它的父类
        //5、throws关键字后也可以是异常列表，即可以抛出多个异常
        FileInputStream fileInputStream = new FileInputStream("hello.tex");
    }
}
