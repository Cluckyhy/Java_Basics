package com.chy.jdbc.preparedstatement;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

@SuppressWarnings({"all"})
//演示 PreparedStatement 的使用 DML语句
public class PreparedStatementDML {
    public static void main(String[] args) throws Exception {
        //创建一个Scanner对象
        Scanner scanner = new Scanner(System.in);
        //提示用户输入用户名
        System.out.print("请输入管理员名：");
        //让用户输入管理员名和密码
        String admin_name = scanner.nextLine();
        //提示用户输入密码
        //System.out.print("请输入管理员密码：");
        //String admin_pwd = scanner.nextLine();

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

        //添加数据
        //String sql = "insert into admin values(?,?)";

        //修改数据
        //String sql = "update admin set pwd = ? where name = ?";

        //删除数据
        String sql = "delete from admin where name = ?";

        //3.2、preparedStatement 对象实现了 PreparedStatement 接口的实现类的对象
        java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //3.3、给 ? 赋值
        preparedStatement.setString(1, admin_name);
        //preparedStatement.setString(1, admin_pwd);

        //4、执行 DML 语句使用 executeUpdate
        //如果执行的是 dml(update, insert, delete) 使用 executeUpdate()
        int rows = preparedStatement.executeUpdate();
        System.out.println(rows > 0 ? "执行成功" : "执行失败");


        //关闭连接
        preparedStatement.close();
        connection.close();
    }
}
