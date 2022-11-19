import java.util.Scanner;

public class Yanghui {
    public static void main(String[] args) {
        //打印杨辉三角
        //定义一个Scanner对象，用户指定打印多少行
        Scanner mysc = new Scanner(System.in);
        System.out.println("请输入你要打印的行数：");
        int row = mysc.nextInt();
        //定义一个二维数组
        int arr[][] = new int[row][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i + 1];
            //给二维数组赋值
            for (int j = 0; j < arr[i].length; j++) {
                if (j == 0 || j == i) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
            }
        }

        //打印二维数组
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

}
