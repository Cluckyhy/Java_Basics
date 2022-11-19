package com.extend_test;

public class Pupil {
    public String name;
    public int age;
    private double score;

    public void setScore(double score) {
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void showInfo() {
        System.out.println("小学生名：" + name + "\t年龄：" + age + "\t成绩：" + score);
    }
}
