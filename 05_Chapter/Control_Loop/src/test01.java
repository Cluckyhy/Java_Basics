import java.util.Scanner;

public class test01 {
    public static void main(String[] args) {
        //创建一个Scanner对象
        Scanner mysc = new Scanner(System.in);
        //用一个double类型的变量来接收金钱
        double money = mysc.nextInt();
        //用一个变量来接收共经过了多少个路口
        int count = 0;
        while(money>1000){
            if(money>50000){
                money -= money*0.05;
            }else{
                money -= 1000;
            }
            count++;
        }
        System.out.println("一共经过了"+count+"个路口");
    }
}
