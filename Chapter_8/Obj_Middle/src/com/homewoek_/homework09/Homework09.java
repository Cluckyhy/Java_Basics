package com.homewoek_.homework09;

public class Homework09 {
    public static void main(String[] args) {
        Student student = new Student("小明",'男',22,"1101");
        student.setHobby("篮球");
        student.info();

        System.out.println("-----------");

        Teacher teacher = new Teacher("小红",'女',25,5);
        teacher.info();
        teacher.setHobby("羽毛球");
        //定义一个Person类型的数组
        Person[] people = new Person[4];
        people[0] = new Student("张三",'男',18,"1001");
        people[1] = new Student("王妞",'女',17,"1002");
        people[2] = new Teacher("拉拉",'女',34,11);
        people[3] = new Teacher("画画",'男',45,22);

        //按年龄从高到底排序
        for (int i = 0; i < people.length-1; i++) {
            for (int j = 0; j < people.length - 1 - i; j++) {
                if(people[j].getAge()<people[j+1].getAge()){
                    Person temp = people[j];
                    people[j] = people[j+1];
                    people[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i]);
        }

        Homework09 test = new Homework09();
        test.duty(student);
        test.duty(teacher);

        //只有当duty方法定义为static就可以直接调用duty()方法
        //duty(student);
        //duty(teacher);

    }

    public void duty(Person person){
        //向下转型
        if (person instanceof Student) {
            Student student = (Student) person;
            student.study();
        } else if (person instanceof Teacher) {
            ((Teacher) person).teach();
        }else{
            System.out.println("do nothing...");
        }
    }
}
