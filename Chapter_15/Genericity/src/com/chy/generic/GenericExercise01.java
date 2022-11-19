package com.chy.generic;

import java.util.*;

public class GenericExercise01 {
    public static void main(String[] args) {
        HashSet<Student> students = new HashSet<>();
        students.add(new Student("小明", 10));
        students.add(new Student("小红", 21));
        //使用增强for循环
        for (Student student : students) {
            System.out.println(student);
        }
        //使用迭代器
        Iterator<Student> iterator1 = students.iterator();
        while (iterator1.hasNext()) {
            Student next = iterator1.next();
            System.out.println(next);
        }


        HashMap<String, Student> map = new HashMap<>();
        map.put("小明", new Student("小明", 10));
        map.put("小红", new Student("小红", 21));
        Set<String> keySet = map.keySet();
        //使用增强for循环
        System.out.println("----------Map-----------");
        for (String o : keySet) {
            System.out.println(map.get(o));
        }
        //使用迭代器
        Set<Map.Entry<String, Student>> entries = map.entrySet();
        Iterator<Map.Entry<String, Student>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Student> obj = iterator.next();
            System.out.println(obj.getKey() + " " + obj.getValue());
        }
    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
