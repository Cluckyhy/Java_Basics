package com.poly_;

public class Master {
    private String name;

    //主人给小狗喂食
//    public void feed(Dog dog, Bone bone) {
//        System.out.println("主人：" + name + "\t给" + dog.getName() + "\t吃" + bone.getName());
//    }
//    public void feed(Cat cat, Fish fish) {
//        System.out.println("主人：" + name + "\t给" + cat.getName() + "\t吃" + fish.getName());
//    }

    //如果动物很多，食物很多
    //====>feed方法就要写很多，不利于管理和维护，代码复用性不高
    //pig --> Rice
    //Tiger --> meat
    //....

    //利用多态实现喂食，可以统一的管理主人喂食的问题
    //animal 编译类型是Animal,可以指向(接收)Animal子类的对象
    //food 编译类型是Food,可以指向(接收)Food子类的对象
    public void feed(Animal animal,Food food){
        System.out.println("主任："+name+"\t给"+animal.getName()+"\t吃"+food.getName());
    }

    public Master(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
