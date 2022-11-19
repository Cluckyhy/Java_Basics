package com.chy.exception_runtime.arrayindexoutofbounds;

public class ArrayIndexOutOfBoundsException01 {
    public static void main(String[] args) {
        int[] arr = {1,3,5};
        for (int i = 0; i <= arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
