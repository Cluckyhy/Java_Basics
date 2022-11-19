package com.chy.collection.set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@SuppressWarnings({"all"})
public class HashSetExercise01 {
    public static void main(String[] args) {
        //创建一个HashSet对象
        Set set = new HashSet();
        //创建三个Employee对象，存放到HashSet中，如果Employee对象的姓名和年龄相同的话，就不能存放在set中
        set.add(new Employee("小红",22));     //OK
        set.add(new Employee("小白",24));     //OK
        set.add(new Employee("小红",22));     //加不进去
        //System.out.println(set);
        for (Object o :set) {
            System.out.println(o);
        }
        Employee lala = new Employee("lala", 22);
        Employee lala1 = new Employee("lala", 22);
        System.out.println(lala.equals(lala1));

    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //重写Object中的equals()方法


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
