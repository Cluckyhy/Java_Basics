package com.chy.decorator_design;

public class BufferedRead_ extends Reader_{
    private Reader_ reader_;        //属性是 Reader_类型

    //构造器接收一个Reader_ 子类对象
    public BufferedRead_(Reader_ reader_) {
        this.reader_ = reader_;
    }

    @Override
    public void ReadFile() {
        reader_.ReadFile();
    }

    @Override
    public void ReadString() {
        reader_.ReadString();
    }

    //扩展读取文件数据的功能：
    //让方法更加灵活，多次读取文件，或则加缓冲 char[]
    public void ReadFiles(int num){
        for (int i = 0; i < num; i++) {
            reader_.ReadFile();
        }
    }

    //扩展读取字符串的功能：
    public void ReadStrings(int num){
        for (int i = 0; i < num; i++) {
            reader_.ReadString();
        }
    }
}
