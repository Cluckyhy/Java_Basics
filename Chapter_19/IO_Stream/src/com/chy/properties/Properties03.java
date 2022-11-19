package com.chy.properties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/*
Properties 父类是 Hashtable，底层就是Hashtable 核心方法
 */
public class Properties03 {
    public static void main(String[] args) throws IOException {
        //使用Properties 类来创建 配置文件，修改配置文件内容

        Properties properties = new Properties();
        //创建
        properties.setProperty("charset", "utf-8");
        properties.setProperty("user", "汤姆");    //注意汤姆保存时，是unicode码值
        properties.setProperty("pwd", "tom111");
        //如果该文件没有key就是创建
        //如果该文件有key，就是修改
        properties.setProperty("pwd","888888");

        //将k-v 存储到文件中即可
        properties.store(new FileOutputStream("D:\\JUFE_Second\\Java_Study\\JavaCode\\JavaSE\\Chapter_19\\IO_Stream\\src\\mysql.properties2"), "hello World");
        System.out.println("保存配置文件成功！");
    }
}
