import java.util.Scanner;

/**
 * @author qinggeng
 */
public class Testlw {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();

        int min = Integer.MAX_VALUE;
        // i 代表走的人数
        for (int i = 0; i < n; i++) {
            // j 代表买的礼物的个数
            for (int j = 0; j < n - i; j++) {
                // 恰好平分
                if ((m + j) % (n - i) == 0) {
                    min = Math.min(min, j * b + i * a);
                    if (min == 0) {
                        System.out.println(0);
                        return;
                    }
                }
            }
        }
        System.out.println(min);
    }
}
