public class Start {
    public static void main(String[] args) {
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < i+1; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//        for (int i = 0; i < 6; i++) {
//            for (int j = 0; j < 6 + i; j++) {
//                if(j<5-i){
//                    System.out.print(" ");
//                }else{
//                    System.out.print("*");
//                }
//            }
//            System.out.println();
//        }
//        int totalLevel = 25;
//        for (int i = 1; i <= totalLevel; i++) {
//            for (int j = 1; j <= totalLevel - i; j++) {
//                System.out.print(" ");
//            }
//            for (int k = 1; k <= 2 * i - 1; k++) {
//                if (k == 1 || k == 2 * i - 1 || i == totalLevel) {
//                    System.out.print("*");
//                } else {
//                    System.out.print(" ");
//                }
//            }
//            System.out.println();
//        }
        //打印一个空心菱形
        int totalLevel = 5;
        int a = 0;
        for (int i = 1; i <= 2 * totalLevel - 1; i++) {
            if (i <= totalLevel) {
                for (int j = 1; j <= totalLevel - i; j++) {
                    System.out.print(" ");
                }
                for (int k = 1; k <= 2 * i - 1; k++) {
                    if (k == 1 || k == 2 * i - 1) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            } else {
                a++;
                for (int q = 1; q <= i - totalLevel; q++) {
                    System.out.print(" ");
                }
                for (int w = 1; w <= (2 * totalLevel - 1) - (2 * a); w++) {
                    if (w == 1 || w == (2 * totalLevel - 1) - (2 * a)) {
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
}
