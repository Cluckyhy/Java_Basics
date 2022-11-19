package com.chy.homework;

import java.util.HashSet;
import java.util.Objects;

@SuppressWarnings({"all"})
public class Homework05 {
    public static void main(String[] args) {
        HashSet set = new HashSet();            //OK
        Person_ p1 = new Person_(1001, "AA");   //OK
        Person_ p2 = new Person_(1002, "BB");   //OK
        set.add(p1);                            //OK
        set.add(p2);                            //OK
        p1.setName("CC");
        set.remove(p1);                         //当把name改为"CC"后，对象的hashCode值就发生改变了，所以删除的不是原来的地址，而发现删除空
        System.out.println(set);                //两个
        set.add(new Person_(1001, "CC"));
        System.out.println(set);                //三个
        set.add(new Person_(1001, "AA"));
        System.out.println(set);                //四个
    }
}

class Person_ {
    private int id;
    private String name;

    public Person_(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person_ person_ = (Person_) o;
        return id == person_.id && Objects.equals(name, person_.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Person_{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
