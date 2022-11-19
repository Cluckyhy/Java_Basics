package com.chy.jdbc.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

//演示C3P0的使用
public class C3P0_ {
    @Test
    //方式1：相关参数，在程序中指定user，url，password等
    public void testC3P0_01() throws Exception {
        //1、创建一个数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        //2、通过配置文件 mysql.properties获取相关的连接信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        //读取相关信息
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        //给数据源 comboPooledDataSource 设置相关的参数
        //注意：连接管理是由 comboPooledDataSource 来管理的
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);

        //设置初始化连接数
        comboPooledDataSource.setInitialPoolSize(10);
        //最大连接数，一定要理解，初始连接池中有10个连接，当10个不够用时，进行扩容，
        //但是最大只能扩容到50个连接，也就是说连接池中最多只能有50个连接
        comboPooledDataSource.setMaxPoolSize(50);
        //测试连接池的效率，测试连接对mysql 5000次操作
        System.out.println("开始连接...");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = comboPooledDataSource.getConnection();//这个方法就是从 DataSource 接口实现的
            //System.out.println("连接成功..");
            //关闭
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("C3P0 5000连接mysql 耗时：" + (end - start));
    }

    @Test
    //第二种方式 使用配置文件模板来完成
    //1、将C3P0 提供的c3p0.config.xml 拷贝到 src目录下
    //2、该文件指定了连接数据库和连接池的相关参数
    public void testC3P0_02() throws SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("chy_c3p0");

        //直接连接
        //测试5000次连接mysql
        System.out.println("开始执行..");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = comboPooledDataSource.getConnection();
            //System.out.println("利用配置文件，连接成功...");
            //关闭连接
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("c3p0的第二种连接方式 耗时：" + (end - start));
    }
}
