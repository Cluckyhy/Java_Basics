package com.chy.annotation_;

public class Deprecated {
    public static void main(String[] args) {
        /*
        @Deprecated 的说明：
            1、用于表示某个程序元素(类，方法，属性)已经过时
            2、可以修饰方法，类，属性，包，参数，等等
            3、源码：
            @Documented
            @Retention(RetentionPolicy.RUNTIME)
            @Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, MODULE, PARAMETER, TYPE})
            4、可以做版本升级的兼容和过渡
         */
        //出现中划线
        A a = new A();
        a.hi();
        System.out.println(a.n1);
    }
}

//1、Deprecated 修饰某个元素，表示该元素已经过时，即不再推荐使用，但是仍然可以使用
@java.lang.Deprecated
class A{
    @java.lang.Deprecated
    public int n1 = 19;
    @java.lang.Deprecated
    public void hi(){
        System.out.println("已经过时的方法，哈哈哈");
    }
}
