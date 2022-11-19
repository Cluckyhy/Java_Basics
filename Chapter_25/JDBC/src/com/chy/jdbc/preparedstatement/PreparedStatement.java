package com.chy.jdbc.preparedstatement;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

@SuppressWarnings({"all"})
//演示 PreparedStatement 的使用
public class PreparedStatement {
    public static void main(String[] args) throws Exception {
        //创建一个Scanner对象
        Scanner scanner = new Scanner(System.in);
        //提示用户输入用户名
        System.out.print("请输入管理员名：");
        //让用户输入管理员名和密码
        String admin_name = scanner.nextLine();
        //提示用户输入密码
        System.out.print("请输入管理员密码：");
        String admin_pwd = scanner.nextLine();

        //通过Properties对象获取配置文件信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        //获取相关的值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        //1、注册驱动
        Class.forName(driver);
        //2、得到连接
        Connection connection = DriverManager.getConnection(url, user, password);
        //3、得到PreparedStatement
        //3.1、组织SQL语句，Sql 语句的 ？ 就相当于 占位符
        String sql = "select name, pwd from admin where name = ? and pwd = ?";

        //3.2、preparedStatement 对象实现了 PreparedStatement 接口的实现类的对象
        java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //3.3、给 ? 赋值
        preparedStatement.setString(1,admin_name);
        preparedStatement.setString(2,admin_pwd);

        //4、执行 select 语句使用 executeQuery
        //如果执行的是 dml(update, insert, delete) 使用 executeUpdate()
        //这里执行 executeQuery，不要再写sql
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            System.out.println("恭喜！登录成功");
        }else{
            System.out.println("对不起，登录失败");
        }

        //用户名
        //1' or
        //万能密码
        //or '1' = '1

        //关闭连接
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
