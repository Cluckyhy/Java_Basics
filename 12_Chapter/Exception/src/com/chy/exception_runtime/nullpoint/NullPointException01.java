package com.chy.exception_runtime.nullpoint;

public class NullPointException01 {
    public static void main(String[] args) {
        /*
        空指针异常
            当应用程序试图在需要对象的地方使用null时，即对象还没有创建出来就使用对象的方法..抛出该异常。
         */
        String name = null;
        System.out.println(name.length());
    }
}
