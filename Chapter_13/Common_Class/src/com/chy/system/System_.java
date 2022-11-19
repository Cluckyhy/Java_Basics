package com.chy.system;

import java.lang.reflect.Array;
import java.util.Arrays;

public class System_ {
    public static void main(String[] args) {
        ////1、exit 退出当前程序
        //System.out.println("ok1");
        ////exit(0) 表示程序退出
        ////0 表示一个状态，正常的状态
        //System.exit(0);
        //System.out.println("ok2");

        //2、arraycopy：复制数组元素，比较适合底层调用
        //一般使用Arrays.copyOf完成复制数组
        int[] src = {1, 2, 4};
        int[] dest = new int[3];    //dest 当前是{0,0,0}
        System.arraycopy(src, 1, dest, 1, 2);
        System.out.println("dest = "+ Arrays.toString(dest));

        //3、currentTimeMillis:返回当前时间距离1970-1-1的毫秒数
        System.out.println(System.currentTimeMillis());
    }
}
