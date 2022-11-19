package com.encap;

public class Encapsulation01 {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("战三");
        person.setAge(30);
        person.setSalary(20000);
        person.info();
        Person xixi = new Person("xixi", 233, 3333);
        xixi.info();
    }
}


class Person {
    public String name;
    private int age;
    private double salary;

    //构造器

    public Person() {
    }

    public Person(String name, int age, double salary) {
//        this.name = name;
//        this.age = age;
//        this.salary = salary;
        //我们可以将set方法写在构造器中，这样仍然可以验证
        this.setName(name);
        this.setAge(age);
        this.setSalary(salary);
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
        //判断
        if (age >= 1 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("你设置的年龄不对，需要在(1-120)，给定的默认年龄为：18");
            this.age = 18;//给一个默认年龄
        }

    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void info() {
        System.out.println("姓名为：" + this.name + "\t年龄为：" + this.age + "\t薪水为：" + this.salary);
    }
}
