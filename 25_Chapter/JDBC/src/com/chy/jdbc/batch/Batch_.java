package com.chy.jdbc.batch;

//演示java的批处理

import com.chy.jdbc.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Batch_ {
    @Test
    //传统方法，添加5000条数据到admin2中
    public void noBatch() throws Exception {
        //1、得到一个连接
        Connection connection = JDBCUtils.getConnection();
        //2、定义sql语句
        String sql = "insert into admin2 values(null,?,?)";
        //3、得到一个preparedStatement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //4，设置占位符中的数据
        System.out.println("开始执行");
        long start = System.currentTimeMillis();    //开始时间
        for (int i = 0; i < 5000; i++) {    //5000执行
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setString(2, "666");
            preparedStatement.executeUpdate();
        }
        long end = System.currentTimeMillis();      //结束时间
        System.out.println("传统的方式 耗时：" + (end - start));
        //关闭连接
        JDBCUtils.close(null, preparedStatement, connection);
    }

    @Test
    //使用批量方式添加数据
    public void Batch() throws Exception {
        //1、得到一个连接
        Connection connection = JDBCUtils.getConnection();
        //2、定义SQL语句
        String sql = "insert into admin2 values(null,?,?)";
        //3、得到一个preparedStatement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行");
        long start = System.currentTimeMillis();    //开始时间
        //循环添加5000条数据
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1, "Rose" + i);
            preparedStatement.setString(2, "123456");
            //将数据加入到批处理包
            preparedStatement.addBatch();
            //每次处理1000条记录
            if((i+1) %1000 == 0){   //满足1000条sql
                preparedStatement.executeBatch();
                //并且清空批处理包，再装入数据
                preparedStatement.clearBatch();
            }
        }
        long end = System.currentTimeMillis();      //结束时间
        System.out.println("批量处理的方式 耗时：" + (end - start));  //批量处理的方式耗时
        //关闭连接
        JDBCUtils.close(null,preparedStatement,connection);
    }
}
