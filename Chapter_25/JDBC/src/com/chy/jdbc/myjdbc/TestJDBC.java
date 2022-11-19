package com.chy.jdbc.myjdbc;

public class TestJDBC {
    public static void main(String[] args) {
        //完成对mysql的操作
        JdbcInterface jdbcInterface1 = new MysqlJdbcImplement();
        jdbcInterface1.getConnection();  //通过接口来调用实现类【动态绑定机制】
        jdbcInterface1.crud();
        jdbcInterface1.close();

        System.out.println("-------------------");

        //完成对oracle的操作
        JdbcInterface jdbcInterface2 = new OracleJdbcImplement();
        jdbcInterface2.getConnection();  //通过接口来调用实现类【动态绑定机制】
        jdbcInterface2.crud();
        jdbcInterface2.close();
    }
}
