public class TwoDimensionArr01 {
    public static void main(String[] args) {
        //下面数组定义是正确的
//        String strs[] = {"a","b","c"};
//        String strs2[] = new String[]{"a","b","c"};


        //一个有三个一维数组，每个一维数组的元素是不一样的
        int arr[][] = new int[10][];
        for (int i = 0; i < arr.length; i++) {
            //给每一个一维数组开辟空间new
            //如果没有给一维数组new 那么arr[i]就是null
            arr[i] = new int[i + 1];

            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = i + 1;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
