package com.poly_;

public class Poly01 {
    public static void main(String[] args) {
        Master master = new Master("小明");
        Dog dog = new Dog("大黄");
        Bone bone = new Bone("大棒骨");
        master.feed(dog, bone);

        Cat cat = new Cat("小花");
        Fish fish = new Fish("小鱼");
        System.out.println("--------------");
        master.feed(cat, fish);

    }
}
