package com.chy.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"all"})
public class MapExercise01 {
    public static void main(String[] args) {
        //创建三个对象
        Employee hong = new Employee("001", "小红", 12000);
        Employee ming = new Employee("002", "小明", 20000);
        Employee bai = new Employee("003", "小白", 13000);
        Employee zhang = new Employee("004", "张三", 40000);
        //创建一个HashMap对象
        HashMap map = new HashMap();
        //往map中添加对象
        map.put(hong.getId(), hong);
        map.put(ming.getId(), ming);
        map.put(bai.getId(), bai);
        map.put(zhang.getId(), zhang);

        //使用KeySet()，先得到map中的所有key值
        Set keyset = map.keySet();
        //增强for循环遍历map
        System.out.println("---------使用增强for---------(1)");
        for (Object key : keyset) {
            //先向下转型为
            Employee m = (Employee)map.get(key);
            if(m.getSal()>18000){
                System.out.println(m);
            }
        }
        //使用迭代器
        System.out.println("---------使用迭代器---------(2)");
        Iterator iterator = keyset.iterator();
        while (iterator.hasNext()) {
            Object key =  iterator.next();
            Employee m = (Employee)map.get(key);
            if(m.getSal()>18000){
                System.out.println(m);
            }
        }

        System.out.println("---------使用entrySet()的增强for---------(3)");
        //使用EntrySet集合
        Set entryset = map.entrySet();
        //使用增强for循环
        for (Object obj : entryset) {
            Map.Entry m =(Map.Entry)obj;
            Employee em = (Employee) m.getValue();
            if(em.getSal()>18000){
                System.out.println(m.getKey() + " "+ m.getValue());
            }
        }


        System.out.println("---------使用entrySet()的迭代器---------(4)");
        //使用迭代器
        Iterator iterator1 = entryset.iterator();
        while (iterator1.hasNext()) {
            Object obj =  iterator1.next();
            //先把Object向下转型为Map.Entry类型
            Map.Entry m = (Map.Entry) obj;
            //把m.getValue()的Object类型向下转型为 Employee类型
            Employee em = (Employee) m.getValue();
            if(em.getSal()>18000){
                System.out.println(m.getKey() + " " + m.getValue());
            }
        }


    }
}

class Employee {
    private String id;
    private String name;
    private int sal;

    public Employee(String id, String name, int sal) {
        this.id = id;
        this.name = name;
        this.sal = sal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sal=" + sal +
                '}';
    }
}
