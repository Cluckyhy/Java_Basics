package com.chy.string;

/*
1、String 对象用于保存字符串，也就是一组字符序列
2、字符串常量对象是用双引号括起来的字符序列。例如："你好"，"12.2"，"boy"等
3、字符串的字符使用Unicode字符编码，一个字符(不区分字母还是汉字)占两个字节
4、String 类很多构造器，构造器的重载
    常用的有 String s1 = new String()
    String s2 = new String(String original);
    String s3 = new String(char[] a);
    String s4 = new String(char[] a, int startIndex, int count)
    String s5 = new String(byte[] b)
5、String 类实现了接口 Serializable【String 可以串行化:可以在网络传输】
            实现了接口 Comparable 【String 对象可以比较大小】
6、String 是 final 类；不能被其他类继承
7、String 有属性 private final char value[];  用于存放字符串内容
8、一定要注意：value是一个final类型，不可以修改(需要功底)  即value不能指向新的地址，但是单个字符内容是可以变化的
    注意：这里的value不能指向新的地址，是""里面的地址不能变，不要被下面的搞糊涂了
    下面的并没有改变value的指向，因为常量池中lulu的地址还是在那，chy的地址也在那，只不过是name这个引用，指向了另一个地方
    并未对"lulu"的数据空间进行修改
    这里一定要区分，value地址，和引用地址
    但是如果是直接赋值方式：
        String name = "lulu";
        name = "chy";
        这里的name只是一个引用 指向是可以改变的，是在常量池中创建一个"chy"，然后让name指向它，name以前是指向lulu的

 */

public class String01 {
    public static void main(String[] args) {
        String name = "jack";               //其实这里返回的是一个地址
        System.out.println("Rose");         //"Rose"，虽然是直接打出来的字符串，但还是返回一个地址
        name = "tom";

        final char value[] = {'a', 'b', 'c'};
        value[0] = 'h';
        char[] v2 = {'t', 'o', 'm'};
        //value = v2;   //ERROR

        String a = "abc";
        String b = "abc";
        System.out.println(a.equals(b));
        System.out.println(a == b);
    }
}


