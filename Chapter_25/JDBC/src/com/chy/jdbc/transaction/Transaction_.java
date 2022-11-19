package com.chy.jdbc.transaction;

import com.chy.jdbc.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//演示在JBDC中，如何使用事务
public class Transaction_ {

    //操作转账的业务
    //没有使用事务
    //在默认情况下，connection是默认自动提交
    @Test
    public void noTransaction(){
        //1、得到连接
        Connection connection = null;

        //2、组织一个sql语句
        String sql1 = "update account set balance = balance - 100 where id = 1";
        String sql2 = "update account set balance = balance + 100 where id = 2";

        //3、创建一个PreparedStatement 对象
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            //执行
            preparedStatement = connection.prepareStatement(sql1);  //执行第一条sq
            preparedStatement.executeUpdate();

            int i = 1 / 0;  //抛出异常

            preparedStatement = connection.prepareStatement(sql2);  //执行第二条sql
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }

    @Test
    //使用事务来解决
    public void useTransaction(){
        //1、得到连接
        Connection connection = null;

        //2、组织一个sql语句
        String sql1 = "update account set balance = balance - 100 where id = 1";
        String sql2 = "update account set balance = balance + 100 where id = 2";

        //3、创建一个PreparedStatement 对象
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();

            //将connection设置为不自动提交，相当于开启了事务
            connection.setAutoCommit(false);

            //执行
            preparedStatement = connection.prepareStatement(sql1);  //执行第一条sq
            preparedStatement.executeUpdate();

            //int i = 1 / 0;  //抛出异常

            preparedStatement = connection.prepareStatement(sql2);  //执行第二条sql
            preparedStatement.executeUpdate();

            //在这里提交事务
            connection.commit();

        } catch (SQLException e) {
            //这里我们可以进行回滚，即撤销执行的sql语句
            //默认回滚到事务开始的状态
            System.out.println("执行发生了异常，撤销执行的sql...");
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }
}
