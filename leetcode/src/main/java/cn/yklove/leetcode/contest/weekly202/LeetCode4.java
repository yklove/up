package cn.yklove.leetcode.contest.weekly202;

/**
 * @author qinggeng
 */
public class LeetCode4 {

    public int minDays(int n) {
        int max = (n + 1) / 2;
        int[] dp = new int[max + 1];
        int pre = 0;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int a = pre + 1;
            pre = a;
            int b = Integer.MAX_VALUE;
            if (i % 2 == 0) {
                b = dp[i / 2] + 1;
            }
            int c = Integer.MAX_VALUE;
            if (i % 3 == 0) {
                c = dp[i - 2 * (i / 3)] + 1;
            }
            if (i <= max) {
                dp[i] = Math.min(Math.min(a, b), c);
            } else {
                ans = Math.min(Math.min(a, b), c);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode4().minDays(61455274));
        System.out.println(new LeetCode4().minDays(820592));
        System.out.println(new LeetCode4().minDays(6));
        System.out.println(new LeetCode4().minDays(1));
        System.out.println(new LeetCode4().minDays(56));
    }

}
