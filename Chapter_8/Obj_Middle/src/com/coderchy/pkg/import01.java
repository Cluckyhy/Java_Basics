//package的作用是声明当前类所在的包，需要放在类(或者文件)的最上面
//一个类中最多只有一句package
package com.coderchy.pkg;

//import指令，位置放在package的下面，在类定义前面，可以有多句且没有顺序要求
import java.util.Arrays;
//...

//注意：
//建议：我们需要使用到哪个类，就导入哪个类即可，不建议使用*
//import java.util.*;
//import java.util.Scanner;
public class import01 {
    public static void main(String[] args) {
        //使用系统提供的Arrays 完成排序
        int arr[] = {-1,20,3,43};
        //比如对其进行排序
        //传统的方法是，自己编写排序(冒泡)
        //系统是提供了相关的类，可以方便完成Arrays
        Arrays.sort(arr);
        int a = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
    }
}
