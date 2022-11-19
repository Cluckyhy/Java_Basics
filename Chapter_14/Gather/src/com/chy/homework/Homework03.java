package com.chy.homework;

import java.util.*;

@SuppressWarnings({"all"})
public class Homework03 {
    public static void main(String[] args) {
        Map m = new HashMap();

        m.put("jack",650);
        m.put("tom",1200);
        m.put("smith",2900);

        m.put("jack",2600);
        Set keyset = m.keySet();

        for (Object key : keyset) {
            int newSal = (Integer)m.get(key) + 100;
            m.put(key,newSal);
        }
        System.out.println(m);

        //利用EntrySet遍历集合
        Set entrySet = m.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry obj =  (Map.Entry) iterator.next();
            System.out.println(obj.getKey() + " "+ obj.getValue());
        }

        Collection values = m.values();
        for (Object o : values) {
            System.out.println("工资 = "+o);
        }


        //Employee jack = new Employee("jack", 650);
        //Employee tom = new Employee("tom", 1200);
        //Employee smith = new Employee("smith", 2900);

        //((Employee) m.get("jack")).setSal(2600);
        //jack.setSal(26000);

        //m.put(jack.getName(), jack.getSal());
        //m.put(tom.getName(), tom.getSal());
        //m.put(smith.getName(), smith.getSal());

        //利用keySet来遍历集合
        //Set keyset = m.keySet();
        //for (Object o : keyset) {
        //    //double newSal = ((Employee)m.get(o)).getSal() + 100;
        //    //((Employee)m.get(o)).setSal(newSal);
        //    //System.out.println(m.get(o));
        //    //System.out.println("员工的工资为："+((Employee) m.get(o)).getSal());
        //    System.out.println(m.get(o));
        //}

    }
}

class Employee {
    private String name;
    private double sal;

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
}
