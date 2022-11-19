package com.chy.generic;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;

public class GenericExercise02 {
    public static void main(String[] args) {
        //创建3个员工类

        Employee Jack = new Employee("Jack", 12000);
        Employee Rose = new Employee("Rose", 14000);
        Employee Milan = new Employee("Milan", 23000);
        Employee jack2 = new Employee("Jack", 23000);
        Work work = new Work("Jack", 2000, "女");

        Jack.setBirthday(new MyDate(1998, 5, 19));
        Rose.setBirthday(new MyDate(2001, 3, 28));
        Milan.setBirthday(new MyDate(2005, 4, 28));
        jack2.setBirthday(new MyDate(1993, 11, 23));
        //如果下面代码没写，就会发生空指针异常
        work.setBirthday(new MyDate(1822,3,3));


        //创建一个ArrayList集合
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(Jack);
        employees.add(Rose);
        employees.add(Milan);
        employees.add(jack2);
        employees.add(work);
        System.out.println("--------------未排序前--------------");
        System.out.println(employees);

        //对employee集合里面的元素进行排序，sort
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                //下面这段代码其实是没必要的，因为泛型已经约束了传入的类型的是Employee，或者Employee的子类
                //if(!(o1 instanceof Employee && o2 instanceof Employee)){
                //    return 0;
                //}
                //比较name
                int i = o1.getName().compareTo(o2.getName());
                if (i != 0) {
                    return i;
                }
                return o1.getBirthday().compareTo(o2.getBirthday());
                //其实可以将下面的代码进行封装，提高代码复用性    -->  封装到实现了Comparable接口的MyDate类的compareTo()方法中
                ////如果name等的话，再比较年份
                //int i1 = o1.getBirthday().getYear() - o2.getBirthday().getYear();
                //if (i1 != 0) {
                //    return i1;
                //}
                ////如果年份相等的话，再比较月份
                //int i2 = o1.getBirthday().getMonth() - o2.getBirthday().getMonth();
                //if (i2 != 0) {
                //    return i2;
                //}
                ////如果月份再次相等的话，再比较天数
                //return o1.getBirthday().getDay() - o2.getBirthday().getDay();
            }
        });

        System.out.println("--------------未排序后--------------");
        System.out.println(employees);


    }
}


class Employee {
    private String name;
    private double sal;
    private MyDate birthday;

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

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}

class Work extends Employee {

    private String gender;

    public Work(String name, double sal, String gender) {
        super(name, sal);
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return super.toString() + "Work{" +
                "gender='" + gender + '\'' +
                '}';
    }
}

class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    //利用泛型
    @Override
    public int compareTo(MyDate o) {
        //如果name等的话，再比较年份
        int i1 = year - o.getYear();
        if (i1 != 0) {
            return i1;
        }
        //如果年份相等的话，再比较月份
        int i2 = month - o.getMonth();
        if (i2 != 0) {
            return i2;
        }
        //如果月份再次相等的话，再比较天数
        return day - o.getDay();

    }
}
