package com.chy.homework;

public class Homework01 {
    public static void main(String[] args) {
        /*
        编写应用程序，接收命令行的两个参数(整数)，计算两个数除
        计算两个数相除，要求使用方法cal(int n1, int n2)
        对数据格式不正确(NumberFormatException)，缺少命令行参数(ArrayIndexOutOfBoundsException)、除0(ArithmeticException)
        进行异常处理
         */
        //先验证输入的参数个数是否正确，两个参数
        try {
            if (args.length != 2) {
                throw new ArrayIndexOutOfBoundsException("参数个数不对！");
            }

            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);

            int res = cal(n1, n2);

            System.out.println("计算结果为：" + res);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("参数格式不正确！");
        } catch(ArithmeticException e){
            System.out.println("除数为0！");
        }

    }

    public static int cal(int n1, int n2) {
        return n1 / n2;
    }
}
