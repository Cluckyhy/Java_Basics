package com.homewoek_.homework04;

public class Teach extends Employee{
    private int classDay;
    private double classSal;

    public Teach(String name, double sal) {
        super(name, sal);
        this.classDay = classDay;
        this.classSal = classSal;
    }

    public int getClassDay() {
        return classDay;
    }

    public void setClassDay(int classDay) {
        this.classDay = classDay;
    }

    public double getClassSal() {
        return classSal;
    }

    public void setClassSal(double classSal) {
        this.classSal = classSal;
    }

    @Override
    public void getAllsal() {
        System.out.print("老师");
        System.out.println("姓名："+getName()+"\t全年工资为："+(getSalmonth()*getSal()+classDay*classSal));
    }
}
