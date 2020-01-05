package cn.yklove.leetcode.contest.weekly170;

/**
 * @author qinggeng
 */
public class LeetCode4 {

    public static void main(String[] args) {
        System.out.println(new LeetCode4().minInsertions("zzazz"));
        System.out.println(new LeetCode4().minInsertions("mbadm"));
        System.out.println(new LeetCode4().minInsertions("leetcode"));
        System.out.println(new LeetCode4().minInsertions("g"));
        System.out.println(new LeetCode4().minInsertions("no"));
    }

    public int minInsertions(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        String s2 = stringBuilder.reverse().toString();
        return s.length() - findLCS(s,s.length(),s2,s2.length());
    }
    public static int findLCS(String A, int n, String B, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = 0;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i - 1][j] > dp[i][j - 1] ? dp[i - 1][j] : dp[i][j - 1];
                }
            }
        }
        return dp[n][m];
    }

}
