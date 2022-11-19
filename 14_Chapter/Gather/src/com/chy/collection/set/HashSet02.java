package com.chy.collection.set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@SuppressWarnings({"all"})
public class HashSet02 {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add(new Employee01("小明", 1200, new MyDate(1998, 4, 21)));
        set.add(new Employee01("小红", 1300, new MyDate(2000, 4, 19)));
        set.add(new Employee01("小明", 4300, new MyDate(1998, 4, 21)));
        for (Object o :set) {
            System.out.println(o);
        }
    }
}

class Employee01 {
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee01(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee01 that = (Employee01) o;
        return Objects.equals(name, that.name) && Objects.equals(birthday, that.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }

    @Override
    public String toString() {
        return "Employee01{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year && month == myDate.month && day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}