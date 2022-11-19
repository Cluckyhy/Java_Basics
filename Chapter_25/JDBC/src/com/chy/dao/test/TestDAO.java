package com.chy.dao.test;

import com.chy.dao.dao.ActorDAO;
import com.chy.dao.dao.GoodsDAO;
import com.chy.dao.domain.Actor;
import com.chy.dao.domain.Goods;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestDAO {
    @Test
    //测试ActorDao 对 actor表的crud操作
    public void testActorDAO() {
        ActorDAO actorDAO = new ActorDAO();
        //1、查询
        List<Actor> actors = actorDAO.queryMulti("select * from actor where id >= ?", Actor.class, 1);
        System.out.println("====查询结果====");
        for (Actor actor : actors) {
            System.out.println(actor);
        }

        //2、查询单行记录
        Actor actor = actorDAO.querySingle("select * from actor where id = ?", Actor.class, 3);
        System.out.print("====查询单行结果====");
        System.out.println(actor);

        //3、查询单行单列
        Object obj = actorDAO.queryScalar("select name from actor where id = ?", 1);
        System.out.println("====查询单行单列的结果====");
        System.out.println(obj);

        //4、dml操作 insert,update,delete
        int update = actorDAO.update("insert into actor values(null,?,?,?,?)", "张无忌", "男", "2000-11-22", "999");
        System.out.println(update > 0 ? "执行成功" : "没有影响到表");
    }

    @Test
    //测试GoodsDAO 对 goods 表的crud操作
    public void testGoodsDAO() {
        //创建一个GoodsDAO对象
        GoodsDAO goodsDAO = new GoodsDAO();
        //1、查询多行记录
        List<Goods> goodsDAOS = goodsDAO.queryMulti("select * from goods where id > ?", Goods.class, 0);
        System.out.println("====查询结果====");
        for (Goods goods : goodsDAOS) {
            System.out.println(goods);
        }

        //2、查询单行记录
        Goods goods = goodsDAO.querySingle("select * from goods where id = ?", Goods.class, 10);
        System.out.println("====查询单行记录====");
        System.out.println(goods);

        //3、查询单行单列信息
        Object obj = goodsDAO.queryScalar("select goods_name from goods where id = ?", 10);
        System.out.println("====查询单行单列信息====");
        System.out.println(obj);

        //4、执行dml操作
        int mi = goodsDAO.update("insert into goods values(?,?,?)", 30, "小米手机", "5000");
        System.out.println(mi > 0 ? "执行成功" : "执行不影响表");
    }
}
