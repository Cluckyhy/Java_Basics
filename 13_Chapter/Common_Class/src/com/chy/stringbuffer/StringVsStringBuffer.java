package com.chy.stringbuffer;

public class StringVsStringBuffer {
    public static void main(String[] args) {
        /*
        1、String保存的是字符串常量，里面的值不能更改，每次String类的更新实际上就是更改地址，效率较低   //private final char value[]
        2、StringBuffer保存的是字符串变量，里面的值可以更改，每次StringBuffer的更新实际上可以更新内容，不用每次更新地址，效率较高
            char[] value;   这个放在堆中
        3、因为StringBuffer 字符内容是存在 char[] value，所以在变化(增加/删除)
            不用每次都更换地址(即不是每次创建新对象)，所以效率高于String
         */
    }
}
