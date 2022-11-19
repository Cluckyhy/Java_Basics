package com.chy.interface_.extends_vs_interface;

public class LitterMonkey extends Monkey implements Fishable,Birdable{
    public LitterMonkey(String name) {
        super(name);
    }

    @Override
    public void climbing() {
        System.out.println(getName()+"会爬树...");
    }

    @Override
    public void swimming() {
        System.out.println(getName()+"通过学习，可以像小鱼儿一样游泳了...");
    }

    @Override
    public void flying() {
        System.out.println(getName()+"通过学习，可以像鸟儿一样飞翔了...");
    }
}
