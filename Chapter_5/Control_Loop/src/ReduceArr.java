import java.util.Scanner;

public class ReduceArr {
    public static void main(String[] args) {
        //定义一个数组
        int arr1[] = {1,2,3,4,5};
        //定义一个Scanner对象
        Scanner mysc = new Scanner(System.in);
        do{
            //提示用户当前数组中的元素
            System.out.println("当前数组中的元素为：");
            for(int i=0;i<arr1.length;i++){
                System.out.print(arr1[i]+" ");
            }
            System.out.println();
            //提示用户是否要缩减数组
            System.out.println("您是否要缩减数组元素?(y/n)");
            char isreduce = mysc.next().charAt(0);
            if(isreduce == 'y'){
                //创建一个新的数组对象
                //新数组对象的长度为原数组长度-1
                int arr2[] = new int[arr1.length-1];
                //将原数组的元素赋值给新数组中
                //先判断原数组中是否为空
                if(arr1.length != 1){
                    for(int i = 0;i<arr2.length;i++){
                        arr2[i] = arr1[i];
                    }
                    arr1 = arr2;
                }else{
                    //提示用户数组只剩下最后一个元素，不能再继续缩减了
                    System.out.println("数组中只剩下最后一个元素，不能再进行缩减了");
                    break;
                }
            }else{
                System.out.println("此时数组中的元素为：");
                for(int i = 0;i<arr1.length;i++){
                    System.out.print(arr1[i]+" ");
                }
                break;
            }
        }while(true);
    }
}
