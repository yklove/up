import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String x = in.nextLine();
            int stringLength = x.length();
            int[] sCount = new int[128];
            for (char c : x.toCharArray())
                sCount[c]++;
            int ans = 0;
            for (int v : sCount) {
                ans += v / 2 * 2;
                if (v % 2 == 1 && ans % 2 == 0)
                    ans++;
            }
            int length = ans;
            if (length == stringLength || length % 2 == 0) {
                System.out.println("Cassidy");
            } else {
                System.out.println("Eleanore");
            }
        }

    }
}
