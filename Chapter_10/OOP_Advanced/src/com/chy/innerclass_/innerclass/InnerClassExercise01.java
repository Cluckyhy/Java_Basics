package com.chy.innerclass_.innerclass;

public class InnerClassExercise01 {
    public static void main(String[] args) {
        Test test = new Test();
        Test.Inner inner = test.new Inner();
        System.out.println(inner.n1);

    }
}

class Test{     //外部类
    public Test() {     //构造器
        Inner s1 = new Inner();
        s1.n1 = 10;
        Inner s2 = new Inner();
        System.out.println(s2.n1);
    }
    //成员内部类
    class Inner{
        public int n1 = 5;
    }
}
