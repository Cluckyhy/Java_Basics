public class test03 {
    public static void main(String[] args) {
        int sum = 0;
        int preSum = 0;
        for (int i = 1; i <= 100; i++) {
            preSum += i;
            sum += preSum;
        }
        System.out.println(sum);
    }
}
