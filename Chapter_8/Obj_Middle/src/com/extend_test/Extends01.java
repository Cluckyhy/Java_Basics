package com.extend_test;

public class Extends01 {
    public static void main(String[] args) {
        Pupil pupil = new Pupil();
        pupil.name = "小明";
        pupil.age = 10;
        pupil.setScore(60);
        pupil.showInfo();

        Graduate graduate = new Graduate();
        graduate.name = "大红";
        graduate.age = 50;
        graduate.setScore(89);
        graduate.showInfo();
    }
}
