package com.chy.try_catch_detail;

public class TryCatchDetail02 {
    public static void main(String[] args) {
        //4、如果try代码块有可能有多个异常
        //5、可以使用多个catch分别捕获不同的异常，相应的处理
        //6、要求子类异常写在前面，父类异常写在后面
        //7、可以进行try-finally配合使用，这种用法相当于没有捕获异常，因此程序会直接崩溃，
        //      应用场景：就是执行一段代码，不管是否发生异常，都必须执行某个业务逻辑
        //8、try必须要和一个配合使用，catch/finally，不能单独使用try，语法错误！！
        try {
            Person person = new Person();
            //person = null;
            System.out.println(person.getName());   //NullPointException
            int n1 = 10;
            int n2 = 0;
            int res = n1 / n2;  //ArithmeticException
        } catch (NullPointerException e) {
            System.out.println("空指针异常 = " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("算术异常 = " + e.getMessage());
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {

        }
    }
}

class Person {
    private String name = "chy";

    public String getName() {
        return name;
    }
}
