package com.chy.try_catch_exercise;

public class TryCatchExercise03 {
    public static void main(String[] args) {
        /*
        1、如果没有抛出异常，则执行try块中所有语句，不执行catch块中语句，如果有finally，最后还需要执行finally里面的语句
        2、如果出现异常，则try块中异常发生后，try块剩下的语句不再执行。将执行catch块中的语句，如果有finally
            最后还需要执行finally里面的语句！
         */
        System.out.println(method());
    }

    public static int method() {
        int i = 1;
        try {
            i++;    //2
            String[] names = new String[3];
            if (names[1].equals("tom")) {     //空指针
                System.out.println(names[1]);
            } else {
                names[3] = "chy";
            }
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 2;
        } catch (NullPointerException e) {
            return ++i;     //i = 3 ---> 保存到临时变量 temp = 3
        } finally {
            ++i;
            System.out.println("i = " + i); //i = 4
        }
    }
}
