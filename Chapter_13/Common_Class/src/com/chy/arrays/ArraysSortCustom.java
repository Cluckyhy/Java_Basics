package com.chy.arrays;

import java.util.Comparator;

public class ArraysSortCustom {
    public static void main(String[] args) {
        int[] arr = {1, -1, -5, 8, 30};
        //bubbleSort(arr);
        bubbleSort2(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int i1 = (Integer) o1;
                int i2 = (Integer) o2;
                return i1 - i2; //return i2 - i1 (从大到小)
            }
        });
        System.out.println("-----排序后-----");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    //使用冒泡排序
    public static void bubbleSort(int[] arr) {
        //for (int i = 0; i < arr.length - 1; i++) {
        //    for (int j = 0; j < arr.length - 1 - i; j++) {
        //        if(arr[j] > arr[j+1]){
        //            int temp = arr[j];
        //            arr[j] = arr[j+1];
        //            arr[j+1] = temp;
        //        }
        //    }
        //}
    }

    //结合冒泡 + 定制
    public static void bubbleSort2(int[] arr, Comparator c) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //数组的排序，由c.compare(arr[j], arr[j + 1])返回值决定
                if (c.compare(arr[j], arr[j + 1]) > 0) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
