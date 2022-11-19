package com.homewoek_.homework07;

public class Homework07 {
    public static void main(String[] args) {
        Doctor doctor1 = new Doctor("jack",20,"牙科医生",'男',20000);
        Doctor doctor2 = new Doctor("jack",20,"牙科医生",'女',20000);
        System.out.println(doctor1.equals(doctor2));
    }
}
