import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author qinggeng
 */
public class Test2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(in.nextInt());
        }
        int max = 0;
        int ans = 0;
        int count = 0;
        for (int i = 1; i <= 99; i += 2) {
            // 被砍了
            if (set.contains(i)) {
                if (count > max) {
                    max = count;
                    ans = i - count * 2 ;
                } else if (count == max) {
                    if (i - count * 2  < ans) {
                        ans = i - count * 2 ;
                    }
                }
                count = 0;
            } else {
                count++;
            }
        }
        if (count > max) {
            max = count;
            ans = 101 - count * 2 ;
        } else if (count == max) {
            if (101 - count * 2 < ans) {
                ans = 101 - count * 2;
            }
        }
        count = 0;
        for (int i = 2; i <= 100; i += 2) {
            // 被砍了
            if (set.contains(i)) {
                if (count > max) {
                    max = count;
                    ans = i - count * 2 ;
                } else if (count == max) {
                    if (i - count * 2  < ans) {
                        ans = i - count * 2 ;
                    }
                }
                count = 0;
            } else {
                count++;
            }
        }
        if (count > max) {
            max = count;
            ans = 102 - count * 2;
        } else if (count == max) {
            if (102 - count * 2 < ans) {
                ans = 102 - count * 2;
            }
        }
        System.out.println(ans + " " + max);
    }
}
