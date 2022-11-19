public class Homework04 {       //公共类
    int count = 9;              //属性
    public void count1(){
        count = 10;
        System.out.println("count1 = "+count);
    }
    public void count2(){
        System.out.println("count1 = "+count++);    //先输出9，再自增
    }
    //这是Homework04的main方法。任何一个类都可以有main
    public static void main(String[] args) {
        //new Homework04是匿名对象，匿名对象使用后，就不能再使用了，即只能使用一次
        //new Homework04().count1() 创建好匿名对象以后，就调用count1()
        new Homework04().count1();
        Homework04 h1 = new Homework04();
//        h1.count1();
        h1.count2();
        h1.count2();
    }
}
