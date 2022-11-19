package com.poly_.polyarr_;

public class PolyArr {
    public static void main(String[] args) {
        //创建一个Person类型的数组，长度为5
        Person[] person = new Person[5];
        person[0] = new Person("小明", 20);
        person[1] = new Student("拉拉", 18, 67);
        person[2] = new Student("咪咪", 22, 88);
        person[3] = new Teacher("画画", 23, 12000);
        person[4] = new Teacher("佳佳", 24, 34000);

        //for循环调用每个对象的say方法
        for (int i = 0; i < person.length; i++) {
            //编译类型为：Person，运行类型是根据实际的情况由JVM来判断
            System.out.println(person[i].say());
            //使用类型判断 + 向下转型
            if (person[i] instanceof Student) {   //判断person[i]的运行类型是不是Student
                //向下转型
                Student student = (Student) person[i];//向下转型
                student.study();
                //也可以使用一句((Student)person[i]).study();
            } else if (person[i] instanceof Teacher) {
                Teacher teacher = (Teacher) person[i];
                teacher.teach();
            } else if (person[i] instanceof Person) {
            } else {
                System.out.println("你的类型有误！请自己检查");
            }
        }
    }
}
