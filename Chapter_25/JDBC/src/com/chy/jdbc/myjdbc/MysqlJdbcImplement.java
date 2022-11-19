package com.chy.jdbc.myjdbc;

//Mysql 数据库实现了jdbc接口[模拟] 【Mysql厂商开发】
public class MysqlJdbcImplement implements JdbcInterface {

    @Override
    public Object getConnection() {
        System.out.println("得到 mysql 的连接...");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("完成Mysql的增删改查...");
    }

    @Override
    public void close() {
        System.out.println("关闭Mysql的连接...");
    }
}
