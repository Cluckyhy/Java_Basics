package com.homewoek_;

public class Homework03 {
    public static void main(String[] args) {
        //实例化一个副教授
        Adprofesser adprofesser = new Adprofesser("小明", 22, "副教授", 12000.2);
        System.out.println(adprofesser.introduce());
    }
}

class Teacher {
    private String name;
    private int age;
    private String post;
    private double salary;

    public Teacher(String name, int age, String post, double salary) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.salary = salary;
    }

    //业务方法
    public String introduce() {
        return "姓名：" + name + "\t年龄：" + age + "\t职称：" + post + "\t基本工资：" + salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}

class Professer extends Teacher {
    public Professer(String name, int age, String post, double salary) {
        super(name, age, post, salary);
    }

    @Override
    public String introduce() {
        return super.introduce() + "\t我的工资级别是1.3";
    }
}

class Adprofesser extends Teacher {
    public Adprofesser(String name, int age, String post, double salary) {
        super(name, age, post, salary);
    }

    @Override
    public String introduce() {
        return super.introduce() + "\t我的工资级别是1.2";
    }
}

class Lecturer extends Teacher {
    public Lecturer(String name, int age, String post, double salary) {
        super(name, age, post, salary);
    }

    @Override
    public String introduce() {
        return super.introduce() + "\t我的工资级别是1.1";
    }

}