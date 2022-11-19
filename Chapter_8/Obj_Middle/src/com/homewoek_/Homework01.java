package com.homewoek_;

public class Homework01 {
    public static void main(String[] args) {

        //定义一个Person类型的对象数组
        Person[] parr = new Person[3];
        //实例化三个Person对象
        Person person = new Person("小明", 23, "老师");
        Person person1 = new Person("小红", 18, "学生");
        Person person2 = new Person("小王", 34, "工人");
        //将对象存放到数组中
        parr[0] = person;
        parr[1] = person1;
        parr[2] = person2;
        //利用冒泡排序对age进行从大到小排序
        for (int i = 0; i < parr.length - 1; i++) {
            for (int j = 0; j < parr.length - 1 - i; j++) {
                if (parr[j].getAge() < parr[j + 1].getAge()) {
                    Person temp = parr[j];
                    parr[j] = parr[j + 1];
                    parr[j + 1] = temp;
                }
            }
        }
        //输出排序后的数组
        for (int i = 0; i < parr.length; i++) {
            //parr[i].info();
            System.out.println(parr[i].toString());
        }

    }
}

class Person {
    private String name;
    private int age;
    private String job;

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void info() {
        System.out.println("姓名：" + name + "\t年龄：" + age + "\t职业：" + job);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}
