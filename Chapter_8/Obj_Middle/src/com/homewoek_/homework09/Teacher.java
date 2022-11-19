package com.homewoek_.homework09;

public class Teacher extends Person{
    private int work_age;

    public Teacher(String name, char sex, int age, int work_age) {
        super(name, sex, age);
        this.work_age = work_age;
    }

    //特有方法
    public void teach(){
        System.out.println("我承诺，我会认真教学！");
    }

    //重写父类的play()方法
    @Override
    public String play() {
        return super.play()+getHobby();
    }

    //重写父类的info()方法

    @Override
    public void info() {
        System.out.println("老师的信息：");
        super.info();
        System.out.println("工龄："+work_age);
        System.out.println(play());
        teach();
    }

    public int getWork_age() {
        return work_age;
    }

    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }

    @Override
    public String toString() {
        return super.toString()+"Teacher{" +
                "work_age=" + work_age +
                '}';
    }
}
