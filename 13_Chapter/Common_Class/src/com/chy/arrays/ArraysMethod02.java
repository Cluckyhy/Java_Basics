package com.chy.arrays;

import java.util.Arrays;
import java.util.List;

public class ArraysMethod02 {
    public static void main(String[] args) {
        Integer[] arr = {1, 4, 54, 65, 76, 223};
        //binarySearch 通过二分搜索法进行查找，要求必须元素有序
        //1、使用binnarySearch 二分查找
        //2、要求该数组是有序的，如果该数组是无序的，不能使用binarySearch
        //3、如果数组不存在该元素，就返回 -(low + 1)
        int index = Arrays.binarySearch(arr, 64);
        System.out.println(index);

        //copyOf 数组元素的复制
        //如果拷贝的长度 > arr.length 就在新数组的后面 增加null
        Integer[] newArray = Arrays.copyOf(arr, arr.length);
        //Integer[] newArray = Arrays.copyOf(arr,arr.length+1);
        //Integer[] newArray = Arrays.copyOf(arr,-1); //error
        System.out.println("----拷贝完毕后------");
        System.out.println(Arrays.toString(newArray));

        //fill数组元素填充
        //使用指定的元素，去填充 num数组，可以理解为是替换原来的元素
        Integer[] num = new Integer[]{9, 2, 4};
        Arrays.fill(num, 99);
        System.out.println("---num数组填充后---");
        System.out.println(Arrays.toString(num));

        //asList 将一组数组值，转换成list
        //asList方法，会将(2,4,5,6,1)数据转换成一个List集合
        //返回的 asList 编译类型 List(接口)
        //asList 运行类型：java.util.Arrays$ArrayList，即是Arrays类的静态内部类
        List asList = Arrays.asList(2, 4, 5, 6, 1);
        System.out.println("asList = "+asList);
        System.out.println("asList的运行类型是："+asList.getClass());
    }
}
