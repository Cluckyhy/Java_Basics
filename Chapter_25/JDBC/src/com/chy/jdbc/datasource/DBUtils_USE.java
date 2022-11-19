package com.chy.jdbc.datasource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.List;

public class DBUtils_USE {
    @Test
    //使用apache-DBUtils 工具类 + druid 完成对表的crud操作
    public void testQueryMany() throws SQLException {    //返回结果是多行的情况
        //1、得到 连接 (druid)
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2、使用 DBUtils 类和接口，先引入DBUtils 相关的jar文件，加入到本 Project
        //3、创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //4、就可以执行相关的方法，返回ArrayList 结果集
        String sql = "select * from actor";
        //(1) query 方法就是执行sql语句，得到 resultset  ---封装到 ---> ArrayList 集合中
        //(2) 返回
        //(3) connection：连接
        //(4) sql：执行的sql语句
        //(5) new BeanListHandler<>(Actor.class)：在将resultset -> Actor 对象 --> 封装到 ArrayList
        //    底层利用反射机制 去获取 Actor类 的属性，然后进行封装
        //(6) 后面是可变形参，给sql语句中 ? 赋值，可以有多个参数，因为是可变参数Object... params
        //(7) 底层得到了 resultSet, 会在query 方法中关闭，关闭PreparedStatement
        List<Actor> list = queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class));
        System.out.println("输出集合的信息...");
        for (Actor actor : list) {
            System.out.print(actor);
        }

        //释放资源
        JDBCUtilsByDruid.close(null, null, connection);
    }

    @Test
    //演示apache-dbutils + druid 完成返回的结果是单行记录(单个对象)
    public void testQuerySingle() throws SQLException {
        //1、得到 连接 (druid)
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2、使用 DBUtils 类和接口，先引入DBUtils 相关的jar文件，加入到本 Project
        //3、创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //4、就可以执行相关的方法，返回单个对象
        String sql = "select * from actor where id = ?";
        //因为我们返回的单行记录<---->单个对象，使用的 Handler 是 BeanHandler
        Actor actor = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 1);
        System.out.println(actor);
        //5、释放资源
        JDBCUtilsByDruid.close(null, null, connection);
    }

    @Test
    //演示apache-dbutils + druid 完成查询结果是单行单列-返回的就是object
    public void testScalar() throws SQLException {
        //1、得到 连接 (druid)
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2、使用 DBUtils 类和接口，先引入DBUtils 相关的jar文件，加入到本 Project
        //3、创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();

        //4、就可以执行相关的方法，返回单行单列，返回的就是object
        String sql = "select name from actor where id = ?";
        //因为返回的是一个对象，使用的handler就是 ScalarHandler
        Object obj = queryRunner.query(connection, sql, new ScalarHandler(), 1);
        System.out.println(obj);

        //5、释放资源
        JDBCUtilsByDruid.close(null, null, connection);
    }

    @Test
    //演示apache-dbutils + druid 完成dml操作(update,insert,delete)
    public void testDML() throws SQLException {
        //1、得到 连接 (druid)
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2、使用 DBUtils 类和接口，先引入DBUtils 相关的jar文件，加入到本 Project
        //3、创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();

        //4、这里我们可以组织sql 完成update,insert,delete
        //String sql = "update actor set name = ? where id = ?";
        //String sql = "insert into actor values(null,?,?,?,?)";
        String sql = "delete from actor where id = ?";
        //(1) 执行dml操作是 queryRunner.update()
        //(2) 返回值是受影响的行数
        //int affectedRow = queryRunner.update(connection, sql, "张三丰", 1);
        //int affectedRow = queryRunner.update(connection, sql, "林青霞","女","1993-10-22","899");
        int affectedRow = queryRunner.update(connection, sql, 2);
        System.out.println(affectedRow > 0 ? "执行成功" : "执行没有影响到表");

        //5、释放资源
        JDBCUtilsByDruid.close(null, null, connection);
    }

}
