package com.test.pkg2;

import com.test.pkg1.Person;

public class Work extends Person {
    public void test(){
        Person person = new Person();
        System.out.println(person.name);
        //System.out.println(person.age);  //error
        Work work = new Work();
        System.out.println(work.name+work.age);
        System.out.println(name+age);
    }
}
