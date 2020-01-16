package cn.yklove.leetcode;

/**
 * @author qinggeng
 */
public class LeetCode1027 {
    public int longestArithSeqLength(int[] A) {
        if (A == null || A.length < 3)
            return 0;
        // 二维数组 i,j 代表A[i]的数字在差值等于j的时候等差数列的数量。
        int[][] dp = new int[A.length][20001];
        int max = 0;
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                int distance = A[i] - A[j] + 10000;
                if (dp[j][distance] > 0) {
                    dp[i][distance] = Math.max(dp[i][distance], dp[j][distance] + 1);
                } else {
                    dp[i][distance] = 2;
                }
                max = Math.max(max, dp[i][distance]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode1027 designerService = new LeetCode1027();
        System.out.println(designerService.longestArithSeqLength(new int[]{20, 1, 15, 3, 10, 5, 8}));
    }
}
