package com.chy.enum_;

public class EnumDetail01 {
    public static void main(String[] args) {
        //使用enum关键字后，就不能再继承其他类了，因为enum会隐式继承Enum，而java是单继承机制
        //枚举类和普通类一样，可以实现接口，如下形式；
        //enum 类名 implements 接口1,接口2..{}
        Music.CLASSMUSIC.playing();
    }
}

interface IPlay{
    void playing();
}

enum Music implements IPlay{
    CLASSMUSIC;

    @Override
    public void playing() {
        System.out.println("播放好听的音乐...");
    }
}
