package com.chy.homework;

import java.util.*;

public class Homework01 {
    public static void main(String[] args) {
        User ming = new User(1001, 23, "小明");
        User hong = new User(1002, 12, "小红");
        User bai = new User(1003, 33, "小白");

        //这里指定 T 类型为 User
        DAO<User> userDAO = new DAO<>();
        userDAO.save(ming.getName(),ming);
        userDAO.save(hong.getName(),hong);
        userDAO.save(bai.getName(),bai);

        User u = userDAO.get("小明");
        System.out.println(u);
        System.out.println(userDAO.list());

        userDAO.update(bai.getName(),new User(1004,14,"小黄"));
        System.out.println(userDAO.list());

        userDAO.delete(hong.getName());
        System.out.println(userDAO.list());
    }
}

//定义一个泛型类
class DAO<T>{
    private Map<String,T> m = new HashMap<>();

    public void save(String id, T entity){
        m.put(id,entity);
    }
    public T get(String id){
        return m.get(id);
    }
    public void update(String id,T entity){
        m.put(id,entity);
    }
    public List<T> list(){
        List<T> ts = new ArrayList<>();
        //Set<String> keySet = m.keySet();
        //for (String obj : keySet) {
        //    ts.add(get(obj));
        //}
        //return ts;
        //ts.addAll(m.values());
        //return ts;

        //为什么这里向下强转会出现运行时异常
        return (ArrayList<T>)m.values();      //ERROR，运行报ClassCastException异常
    }
    public void delete(String id){
        m.remove(id);
    }
}

//定义一个User类
class User{
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
