package com.chy.innerclass_.homework;

public class Homework04 {
    public static void main(String[] args) {
        //实例化一辆车
        Car car = new Car();
        Car.Air air = car.new Air();
        car.setTemperature(-3);
        //air.flow();
        air.Flow();
        car.setTemperature(45);
        air.Flow();
        car.setTemperature(23);
        air.Flow();

    }
}

class Car{
    private double temperature;
    //成员内部类
    class Air{
        ////吹风的功能
        //监视车内的温度
        public void Flow(){
            if(temperature <0){
                System.out.println("现在开始吹暖风...");
            }else if(temperature <40){
                System.out.println("吹风机已关闭...");
            }else{
                System.out.println("现在开始吹冷风...");
            }
        }
    }
    public Air getAir(){
        return new Air();
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
