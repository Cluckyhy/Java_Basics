package com.chy.interface_.interface_exercise;

public class InterfaceExercise01 {
    public static void main(String[] args) {

    }
}

interface A{
    int x = 0;  //等价于：public static final int x = 0;
}

class B{
    int x = 1;  //普通属性
}

class C extends B implements A{
    public void Px(){
        //没有明确指定x
        //System.out.println(x);  //ERROR，原因有歧义
        //可以明确指定x
        //可以访问接口的x 就使用 A.x  因为A内的属性都是静态的
        //可以访问父类的 x 就使用 super.x
        System.out.println(A.x + " " + super.x);
        //System.out.println(B.this.x);     //B.this.x是内部类访问外部类重名属性的方式，但是这里并不是内外部类的关系，只能使用super.x
    }
    public static void main(String[] args){
        new C().Px();
    }
}
