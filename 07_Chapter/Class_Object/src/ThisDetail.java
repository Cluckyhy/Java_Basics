public class ThisDetail {
    public static void main(String[] args) {
        T t1 = new T();
    }
}

//1、this关键字可以用来访问本类的属性、方法、构造器
//2、this用于区分当前类的属性和局部变量
//3、访问成员方法的语法：this.方法名(参数列表)
//4、访问构造器语法：this(参数列表);注意只能在构造器中使用(即只能在构造器中调用访问另外一个构造器)
//5、this不能在类定义的外部使用，只能在类定义的方法中使用。

class T{
    public T(){
        //注意：如果有访问构造器语法：this(参数列表);必须放置在第一条语句
        //这里访问T(String name)，并且语句必须放在第一条语句
        this("jake");
        System.out.println("T() 构造器");
    }
    public T(String name){
        System.out.println("T(String name) 构造器");
    }
    public void f1(){
        System.out.println("f1()方法");
    }
    public void f2(){
        System.out.println("f2()方法");
        f1();
        this.f1();
    }
}