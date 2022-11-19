package com.chy.interface_.extends_vs_interface;

public class Monkey {
    private String name;

    public void climbing() {
        System.out.println(name + "会爬树...");
    }

    public Monkey(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
