package com.homewoek_.homework04;

public class Worker extends Employee{
    public Worker(String name, double sal) {
        super(name, sal);
    }

    @Override
    public void getAllsal() {
        System.out.print("工人");
        super.getAllsal();
    }
}
