package com.chy;

public class Homework03 {
    public static void main(String[] args) {
        //实例化一本书
        Book b1 = new Book(43);
        b1.updatePrice(78);
        System.out.println(b1.m_price);
        b1.updatePrice(899);
        System.out.println(b1.m_price);
        b1.updatePrice(123);
        System.out.println(b1.m_price);
    }
}

class Book{
    //成员属性
    double m_price;
    //构造方法
    public Book(double price){
        this.m_price = price;
    }
    //成员方法
    public void updatePrice(double price){
        if(price>100 && price<150){
            this.m_price = 100;
        }
        if(price>150){
            this.m_price = 150;
        }
    }

}
