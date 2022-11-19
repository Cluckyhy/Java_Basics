import java.sql.Array;
import java.util.Scanner;

public class AddArr {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        Scanner mysc = new Scanner(System.in);
        char isGo = ' ';
        int num = 0;
        while (true) {
            System.out.println("数组是否继续添加(y/n)：");
            isGo = mysc.next().charAt(0);
            if ('y' == isGo) {
                num = mysc.nextInt();
                int arr2[] = new int[arr.length + 1];
                for (int i = 0; i < arr2.length-1; i++) {
                    arr2[i] = arr[i];
                }
                arr2[arr2.length - 1] = num;
                arr = arr2;
            } else {
                break;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
