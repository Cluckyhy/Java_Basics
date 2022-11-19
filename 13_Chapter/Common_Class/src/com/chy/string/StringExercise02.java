package com.chy.string;

public class StringExercise02 {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "chy";
        Person p2 = new Person();
        p2.name = "chy";

        //第一个，因为String类重写了Object类中的equals()方法，用来比较两个的值是否相等，所以第一个为 true
        System.out.println(p1.name.equals(p2.name));
        //第二个，p1.name和p2.name都是地址，它们都是指向同一个地址，所以也为  true
        System.out.println(p1.name == p2.name);
        //第三个，p1.name是一个地址，注意下面的"chy"也是返回一个地址，而且它们两个的地址是一样的，所以为  true
        System.out.println(p1.name == "chy");
    }
}

class Person{
    public String name;
}
