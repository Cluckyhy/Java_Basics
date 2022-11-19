package com.chy.qqserver.service;

import java.util.HashMap;
import java.util.Iterator;

//该类用于管理和客户端通信的线程
public class ManageServerThreads {
    private static HashMap<String, ServerConnectClientThread> hm = new HashMap<>();

    public static HashMap<String, ServerConnectClientThread> getHm() {
        return hm;
    }

    //添加线程对象到 hm 集合
    public static void addClientThread(String userId,ServerConnectClientThread serverConnectClientThread){
        hm.put(userId,serverConnectClientThread);
    }

    //根据userId，返回ServerConnectClientThread线程
    public static ServerConnectClientThread getServerConnectClientThread(String userId){
        return hm.get(userId);
    }

    //从集合中移出某个线程对象
    public static void removeServerConnectClientThread(String userId){
        hm.remove(userId);
    }

    //这里编写一个方法，可以返回在线用户列表
    public static String getOnLineUser(){
        //集合的遍历，遍历 hashmap的key
        Iterator<String> iterator = hm.keySet().iterator();
        String onLineUserList = "";
        while(iterator.hasNext()){
            onLineUserList += iterator.next().toString() + " ";
        }
        return onLineUserList;
    }

}
