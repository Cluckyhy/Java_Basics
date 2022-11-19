public class BubbleSort {
    public static void main(String[] args) {
        //定义一个数组
        int array[] = {21, 55, 33, 12, 6, 88, 9, -1, 500};
        //冒泡排序
        //外层循环控制轮次
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = true;
            //内层循环控制比较次数
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = false;
                }
            }
            //如果一次都没有发生交换，则直接退出循环
            if(flag){
                break;
            }
        }
        //显示数组
        System.out.println("冒泡排序后的数组：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
