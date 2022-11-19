import java.util.Scanner;

public class SwitchTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符(a-g)");
        char c1 = sc.next().charAt(0);
        //double db = 20.2;
        //switch(表达式)中表达式的返回值必须是：
        //byte short int char String enum
        //case子句中的值必须是常量(1,'a')或者常量表达式，而不能是变量
        switch(c1){
            case 'a':
                System.out.println("今天星期一");
                break;
            case 98:
                System.out.println("今天星期二");
                break;
            case 'c':
                System.out.println("今天星期三");
                break;
            default:
                System.out.println("没啥事了");
                break;
        }
    }
}
