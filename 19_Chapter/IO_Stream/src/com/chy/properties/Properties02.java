package com.chy.properties;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Properties02 {
    public static void main(String[] args) throws IOException {
        /*
        Properties的常见方法
        load：加载配置文件的键值对到Properties对象
        list：将数据显示到指定设备
        getProperty(key)：根据键获取值
        setProperty(key,value)：设置键值对到Properties对象
        store：将Properties中的键值对存储到配置文件，在idea中，保存信息到配置文件，如果含有中文，会存储为unicode码
         */

        //使用Properties 类来读取mysql.properties 文件
        //1、创建Properties 对象
        Properties properties = new Properties();
        //2、加载指定配置文件
        properties.load(new FileReader("D:\\JUFE_Second\\Java_Study\\JavaCode\\JavaSE\\Chapter_19\\IO_Stream\\src\\mysql.properties"));
        //3、把k-v显示到控制台
        properties.list(System.out);
        //4、根据key 获取对应的值
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");
        System.out.println("用户名为：" + user + "密码为：" + pwd);

    }
}
