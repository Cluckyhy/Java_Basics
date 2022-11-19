package com.chy.final_;

public class FinalExercise01 {
    public static void main(String[] args) {
        Circle circle = new Circle(2);
        System.out.println("面积为："+circle.getArea());
    }
}

class Circle{
    private double radius;
    //第一种，直接定义时赋值
    private final double PI = 3.14;

    public Circle(double radius) {
        this.radius = radius;
        //PI = 3.14;
    }
    //{
    //    PI = 3.14;
    //}

    public double getArea(){
        return PI*radius*radius;
    }
}
