package com.chy.homework;

import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings({"all"})
public class Homework01 {
    public static void main(String[] args) {
        //封装一个新闻类，包含标题和内容属性，提供get、set方法，重写toString()方法，打印对象时只打印标题
        News news1 = new News("新闻一：神州13号成功发射！啦啦啦拉拉阿拉啦啦啦啦");
        News news2 = new News("新闻二：男子突然想起2个月前钓的鱼还在网兜里，捞起来赶紧放生");
        System.out.println("未修改前；");
        System.out.println(news1);
        System.out.println(news2);
        //创建一个ArrayList对象
        ArrayList list = new ArrayList();
        list.add(news1);
        list.add(news2);
        Collections.reverse(list);
        //处理后：
        System.out.println("----------新闻处理后---------");
        for (Object o : list) {
            System.out.println(processString(((News)o).getTitle()));
        }

    }

    public static String processString(String title) {
        if (title == null) {
            return "";
        }
        if (title.length() > 15) {
            return title.substring(0, 15) + "...";
        }
        return title;
    }
}

class News {
    private String title;
    private String content;

    public News(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return this.title;
    }
}