package com.chy.map;

import java.util.Properties;

@SuppressWarnings({"all"})
public class Properties_ {
    public static void main(String[] args) {
        Properties properties = new Properties();

        //增加
        /*
        1、Properties 类继承  Hashtable
        2、可以通过 k-v 存放数据，当然key 和 value 不能为 null
         */
        properties.put("John",100);
        //properties.put("Rose",null);    //异常
        //properties.put(null,100);       //异常
        properties.put("lucy",100);
        properties.put("lic",100);
        properties.put("lic",80);       //如果有相同的 key，value被替换

        System.out.println("Properties = "+properties);

        //通过key 获取对应的值
        System.out.println(properties.get("lic"));

        //删除
        properties.remove("lic");
        System.out.println("Properties = "+properties);

        //修改
        properties.put("John","约翰");
        System.out.println("Properties = "+properties);
    }
}
