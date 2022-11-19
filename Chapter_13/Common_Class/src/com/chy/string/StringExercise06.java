package com.chy.string;

public class StringExercise06 {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.change(test1.str, test1.ch);
        System.out.print(test1.str + "  and  ");
        System.out.println(test1.ch);
    }
}

class Test1 {
    String str = new String("chy");
    final char[] ch = {'j', 'a', 'v', 'a'};

    public void change(String str, char ch[]) {
        str = "java";
        ch[0] = 'h';
    }
}