package com.chy.jdbc;

import com.mysql.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


//分析java 连接mysql的5中方式
public class JdbcConn {
    //方式1
    @Test
    public void connect01() throws SQLException {
        Driver driver = new Driver();
        String url = "jdbc:mysql://localhost:3306/chy_db01";
        Properties properties = new Properties();
        properties.setProperty("user", "root");  //用户
        properties.setProperty("password", "yy980519");  //密码
        Connection connect = driver.connect(url, properties);
        System.out.println("方式1：" + connect);
    }

    //方式2
    @Test
    public void connect02() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //使用反射机制加载Driver类，实现动态加载，更加的灵活，减少依赖性
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        String url = "jdbc:mysql://localhost:3306/chy_db01";
        Properties properties = new Properties();
        properties.setProperty("user", "root");  //用户
        properties.setProperty("password", "yy980519");  //密码
        Connection connect = driver.connect(url, properties);
        System.out.println("方式2：" + connect);
    }

    //方式3
    @Test
    public void connect03() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //使用DriverManager 替代 Driver 进行统一管理
        //使用反射加载Driver
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver)aClass.newInstance();

        //创建url 和 password
        String url = "jdbc:mysql://localhost:3306/chy_db01";
        String user = "root";
        String password = "yy980519";
        DriverManager.registerDriver(driver);   //注册Driver驱动

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("方式3："+connection);
    }

    //方式4   这种方式获取连接使用的是最多的
    @Test
    public void connect04() throws ClassNotFoundException, SQLException {
        //使用Class.forName 自动完成注册驱动，简化代码
        //使用反射加载了 Driver类
        //在加载 Driver类时，完成注册
        Class.forName("com.mysql.jdbc.Driver");

        //创建url 和 user 和 password
        String url = "jdbc:mysql://localhost:3306/chy_db01";
        String user = "root";
        String password = "yy980519";

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("方式4："+connection);
    }

    //方式5，在方式4的基础上改进，增加配置文件，让连接mysql更加灵活
    @Test
    public void connect05() throws IOException, ClassNotFoundException, SQLException {
        //通过Properties对象获取配置文件信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        //获取相关的值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println("方式5："+connection);
    }
}
