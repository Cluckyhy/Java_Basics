package com.chy.wrapper_class;

public class WrapperExercise01 {
    public static void main(String[] args) {
        Double d = 100d;
        Float f = 1.5f;

        Object obj1 = true ? new Integer(1) : new Double(2.0);  //三元运算符【是一个整体】
        System.out.println(obj1);   //输入1.0，因为上面的三元运算符的精度最高的是Double，所以按最高精度来输出

        Object obj2;
        if(true){
            obj2 = new Integer(1);
        }else{
            new Double(2.0);
        }
        System.out.println(obj2);   //输出1，因为这里是分别计算的，不会提升优先级
    }
}
