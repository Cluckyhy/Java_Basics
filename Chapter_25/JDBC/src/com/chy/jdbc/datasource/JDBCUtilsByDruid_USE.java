package com.chy.jdbc.datasource;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;

public class JDBCUtilsByDruid_USE {
    @Test
    public void testSelect() {
        System.out.println("使用 Druid 方式完成");
        //1、得到连接
        Connection connection = null;

        //2、组织一个sql语句
        String sql = "select * from actor";

        //3、创建一个PreparedStatement 对象
        PreparedStatement preparedStatement = null;
        java.sql.ResultSet resultSet = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            //执行
            resultSet = preparedStatement.executeQuery();
            //得到结果
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                Date borndate = resultSet.getDate("borndate");
                String phone = resultSet.getString("phone");
                System.out.println(id + "\t" + name + "\t" + sex + "\t" + borndate + "\t" + phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtilsByDruid.close(resultSet, preparedStatement, connection);
        }
    }


    //使用土方法来解决ResultSet =封装==> ArrayList
    @Test
    public void testSelectToArrayList() {
        System.out.println("使用 Druid 方式完成");
        //1、得到连接
        Connection connection = null;

        //2、组织一个sql语句
        String sql = "select * from actor";

        //3、创建一个PreparedStatement 对象
        PreparedStatement preparedStatement = null;
        java.sql.ResultSet resultSet = null;
        ArrayList<Actor> list = new ArrayList<>();      //创建ArrayList对象，存放actor对象
        try {
            connection = JDBCUtilsByDruid.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            //执行
            resultSet = preparedStatement.executeQuery();
            //得到结果
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                Date borndate = resultSet.getDate("borndate");
                String phone = resultSet.getString("phone");
                //System.out.println(id + "\t" + name + "\t" + sex + "\t" + borndate + "\t" + phone);
                //把得到的resultSet的记录，封装到 Actor对象，然后放入到 list 集合
                list.add(new Actor(id, name, sex, borndate, phone));
            }

            //System.out.println("list集合的数据："+list);
            for (Actor actor : list) {
                System.out.println(actor.getName() + "\t" + actor.getPhone());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtilsByDruid.close(resultSet, preparedStatement, connection);
        }
        //因为ArrayList 和 Connection 没有任何关联，所以该集合可以复用。
        //return list;
    }
}
