package com.homewoek_.homework04;

public class Employee {
    private String name;
    private double sal;
    private int salmonth;

    public Employee(String name, double sal) {
        this.name = name;
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public int getSalmonth() {
        return salmonth;
    }

    public void setSalmonth(int salmonth) {
        this.salmonth = salmonth;
    }

    //获取全年工资方法
    public void getAllsal() {
        System.out.println("姓名：" + name + "\t" + "全年工资为：" + sal * salmonth);
    }
}
