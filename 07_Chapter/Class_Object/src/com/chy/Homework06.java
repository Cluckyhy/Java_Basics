package com.chy;

public class Homework06 {
    public static void main(String[] args) {
        //实例化一个圆形对象
        Circle c1 =  new Circle();
        //实例化一个PassObject对象
        PassObject p1 = new PassObject();
        p1.printAreas(c1,5);
    }
}

class Circle{
    //成员属性
    double radius;  //圆的半径
    //构造方法
    public Circle(){}
    public Circle(double radius){
        this.radius = radius;
    }
    //成员方法
    public void setRadius(double radius){
        this.radius = radius;
    }
    public double findArea(){
        return Math.PI*this.radius*this.radius;
    }
}

class PassObject{
    //成员方法
    public void printAreas(Circle c,int times){
        System.out.println("Radius"+"\t\t"+"Area");
        for (int i = 1; i <= times; i++) {
            //c.radius = i;
            c.setRadius(i);
            System.out.println((double) i+"\t\t\t"+c.findArea());
        }
    }
}
