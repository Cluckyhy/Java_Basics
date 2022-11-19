package com.homewoek_.homework09;

public class Student extends Person{
    //成员属性
    private String stu_id;

    public Student(String name, char sex, int age, String stu_id) {
        super(name, sex, age);
        this.stu_id = stu_id;
    }

    //特有方法
    public void study(){
        System.out.println("我承认，我会好好学习！");
    }

    //重写父类的play()方法
    @Override
    public String play() {
        return super.play()+getHobby();
    }

    //重写父类的info()方法
    @Override
    public void info() {
        System.out.println("学生的信息：");
        super.info();
        System.out.println("学号为："+stu_id);
        System.out.println(play());
        study();
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    @Override
    public String toString() {
        return super.toString()+"Student{" +
                "stu_id='" + stu_id + '\'' +
                '}';
    }
}
