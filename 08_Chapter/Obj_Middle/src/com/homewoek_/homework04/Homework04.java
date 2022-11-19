package com.homewoek_.homework04;

public class Homework04 {
    public static void main(String[] args) {
        Worker worker = new Worker("小明",1200);
        worker.setSalmonth(13);
        worker.getAllsal();
        Teach teach = new Teach("小王",2300);
        teach.setSalmonth(5);
        teach.setClassDay(360);
        teach.setClassSal(1000);
        teach.getAllsal();
    }
}
