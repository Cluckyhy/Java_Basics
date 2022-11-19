package com.chy.innerclass_.homework;

import java.lang.invoke.VarHandle;

public class Homework03 {
    public static void main(String[] args) {
        //实例化一个Person对象
        //Person person = new Person("唐僧",new Transport());
        //person.getTransport().getHorse().work();
        //person.getTransport().getBoat().work();

        Person tang = new Person("唐僧",VehiclesFactory.getHorse());
        tang.common();
        tang.passRiver();
        tang.passRiver();
        tang.common();
        //准备过火焰山
        tang.passFireMountain();
    }
}

/*
1、有一个交通工具接口类Vehicles，有work接口
2、有Horse类和Boat类分别实现Vehicles
3、创建交通工具类，有两个方法分别获得交通工具Horse和Boat
4、有Person类，有name和Vehicles属性，在构造器中为两个属性赋值
5、实例化Person对象"唐僧"，要求一般情况下用Horse作为交通工具，遇到大河时用Boat作为交通工具
 */

//定义一个交通工具类
interface Vehicles{
    void work();
}

//Horse类
class Horse implements Vehicles{
    //构造器私有化
    private Horse(){}
    public static Horse horse = new Horse();
    @Override
    public void work() {
        System.out.println("现在的交通工具为马...");
    }
}

//Boat类
class Boat implements Vehicles{
    @Override
    public void work() {
        System.out.println("现在的交通工具为船...");
    }
}

//Airplane类
class Airplane implements Vehicles{
    @Override
    public void work() {
        System.out.println("现在开始起飞了...");
    }
}

//交通工具类
class VehiclesFactory{
    //构造器私有化
    private VehiclesFactory(){}
    //获取Horse工具
    public static Horse getHorse(){
        return Horse.horse;
    }
    //获取Boat工具
    public static Boat getBoat(){
        return new Boat();
    }
    //获取Airplane工具
    public static Airplane getAirplane(){
        return new Airplane();
    }
}

//Person类
class Person{
    //private String name;
    //private Transport transport;
    //
    //public Person(String name, Transport transport) {
    //    this.name = name;
    //    this.transport = transport;
    //}
    //
    //public Transport getTransport() {
    //    return transport;
    //}

    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    //一般情况下用Horse交通工具
    public void common(){
        //获得马儿
        //if(vehicles == null){
        //    vehicles = VehiclesFactory.getHorse();
        //}
        if(!(vehicles instanceof Horse)){
            vehicles = VehiclesFactory.getHorse();
        }
        vehicles.work();
    }
    //遇到大河用Boat交通工具
    public void passRiver(){
        //if(vehicles == null){
        //    vehicles = VehiclesFactory.getBoat();
        //}
        if(!(vehicles instanceof Boat)){
            vehicles = VehiclesFactory.getBoat();
        }
        vehicles.work();
    }

    //过火焰山
    public void passFireMountain(){
        if(!(vehicles instanceof Airplane)){
            vehicles = VehiclesFactory.getAirplane();
        }
        vehicles.work();
    }
}
