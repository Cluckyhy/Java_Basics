import java.util.Scanner;

public class Homework01 {
    public static void main(String[] args) {
        //已知有一个升序的数组，要求插入一个元素，该数组顺序依然是升序，比如[10,12,45,90]，添加23后，
        //数组为[10,12,23,45,90]
        //首先定义一个一维数组
        int arr[] = {10, 12, 23, 45, 90};
        //定义一个Scanner对象
        Scanner mysc = new Scanner(System.in);
        char isGo = ' ';
        do {
            System.out.println("一维数组为；");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            System.out.println("请输入是否要继续添加数据：(y/n)");
            isGo = mysc.next().charAt(0);
            if (isGo == 'y') {
                System.out.println("请输入您要添加的数据：");
                int num = mysc.nextInt();
                //重新定义一个新的数组，新数组是原来数组长度+1
                int arr2[] = new int[arr.length + 1];
                //创建好新数组后，判断要添加的数据放在哪个位置，可以保持数组的有序状态
                //遍历原先的数组，依次和要添加的数据比较大小，得到比要添加数据大的数组下标
                int index = -1;
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] > num) {
                        index = j;
                        break;
                    }
//                    else {
//                        index = arr.length;
//                    }
                }
                if(index == -1){
                    index = arr.length;
                }
                //接着就是给新数组赋值
                for (int k = 0; k < arr2.length; k++) {
                    if (k < index) {
                        arr2[k] = arr[k];
                    } else if (k == index) {
                        arr2[k] = num;
                    } else {
                        arr2[k] = arr[k - 1];
                    }
                }
                //把新数组赋值给原数组
                arr = arr2;
            } else {
                break;
            }
        } while (true);

        //打印新数组
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
