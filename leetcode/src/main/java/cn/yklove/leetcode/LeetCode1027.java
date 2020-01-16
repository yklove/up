package cn.yklove.leetcode;

import java.util.Arrays;

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

    public int longestArithSeqLength2(int[] A) {
        int n = A.length;
        if (n < 2) return n;
        // dp[i][j] 是j 和 i（j-i）做等差数列的最大长度
        int[][] dp = new int[n][n];
        // 存放数值对应在dp中的位置
        int[] index = new int[20001];
        int res = 2;
        Arrays.fill(index, -1);
        for (int i = 0; i < n - 1; i++) {
            Arrays.fill(dp[i], 2);
            for (int j = i + 1; j < n; j++) {
                // 计算出等差数列上一个数字
                int prev = A[i] * 2 - A[j];
                // 如果这个数字小于0(因为给定的数据一定大于0)或者这个数字的索引不存在
                if (prev < 0 || index[prev] == -1) {
                    continue;
                }
                dp[i][j] = dp[index[prev]][i] + 1;
                res = Math.max(res, dp[i][j]);
            }
            index[A[i]] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode1027 designerService = new LeetCode1027();
        System.out.println(designerService.longestArithSeqLength(new int[]{20, 1, 15, 3, 10, 5, 8}));
    }
}
