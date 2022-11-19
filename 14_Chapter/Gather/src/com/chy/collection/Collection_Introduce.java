package com.chy.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Collection_Introduce {
    public static void main(String[] args) {
        /*
        Collection  Map
        1、集合主要是两组(单列集合，双列集合)
        2、Collection 接口有两个重要的子接口  List Set，他们的实现子类都是单列集合
        3、Map接口的实现子类 是双列集合，存放的  K-V
        4、把老师梳理的两张图记住
         */
        ArrayList arrayList = new ArrayList();
        //单列集合
        arrayList.add("tom");
        arrayList.add("jack");
        //双列集合  -->  K-V
        HashMap hashMap = new HashMap();
        hashMap.put("NO1","北京");
        hashMap.put("NO2","南昌");

    }
}
