package com.chy.properties;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
注意：
专门用于读写的配置文件的集合类
配置文件的格式：
键=值
键=值
注意：
   键值对不需要有空格，值不需要用引号引起来。默认类型是String
 */
public class Properties01 {
    public static void main(String[] args) throws IOException {

        //读取mysql.properties 文件，并得到ip，user，pwd
        //注意这里的文件路径是相对路径，相当于从jvm启动位置开始找，对于普通的java项目，jvm启动位置就是项目的根路径
        //这里需要进行环境的配置，将工作目录设置为当前模块目录
        //如果没有配置不能直接使用 src\\mysql.properties
        BufferedReader br = new BufferedReader(new FileReader("D:\\JUFE_Second\\Java_Study\\JavaCode\\JavaSE\\Chapter_19\\IO_Stream\\src\\mysql.properties"));
        String line = "";
        while ((line = br.readLine()) != null) {    //循环读取
            String[] split = line.split("=");
            //如果指定得到ip值
            if("ip".equals(split[0])){
                System.out.println(split[0] + "值是：" + split[1]);
            }
        }

        //关闭流
        br.close();
    }
}
