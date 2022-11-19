package com.chy.decorator_design;

public class Test_ {
    public static void main(String[] args) {
        //创建一个文件流对象
        FileRead_ fileRead_ = new FileRead_();
        //创建一个字符串流对象
        StringRead_ stringRead_ = new StringRead_();

        //创建一个处理流对象
        BufferedRead_ bufferedRead_ = new BufferedRead_(fileRead_);
        //调用默认的文件读功能
        System.out.println("默认功能");
        bufferedRead_.ReadFile();
        //调用BufferedRead_类扩展的功能
        System.out.println("扩展功能");
        bufferedRead_.ReadFiles(10);

        BufferedRead_ bufferedRead_2 = new BufferedRead_(stringRead_);
        //调用默认的字符串读功能
        System.out.println("默认功能");
        bufferedRead_2.ReadString();
        //调用BufferedRead_类扩展的功能
        System.out.println("扩展功能");
        bufferedRead_2.ReadStrings(5);
    }
}
