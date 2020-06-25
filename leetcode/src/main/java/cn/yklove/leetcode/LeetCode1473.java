package cn.yklove.leetcode;

/**
 * @author qinggeng
 */
public class LeetCode1473 {

    /**
     * @param houses 房子原本的颜色
     * @param cost   房子i涂上颜色j的代价
     * @param m      房子的数量
     * @param n      颜色的数量
     * @param target 目标街区
     * @return 最小总花费
     */
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        dp = new int[m + 1][n + 1][n + 1][m + 1];
        int minCost = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int currentCost = function(houses, cost, m, n, target, 0, i, 0, 0);
            minCost = Math.min(minCost, currentCost);
        }
        if (minCost == Integer.MAX_VALUE) {
            return -1;
        }
        return minCost;
    }

    private int[][][][] dp;

    private int function(int[] houses, int[][] cost, int m, int n, int target, int houseIndex, int color, int previousColor, int previousCount) {
        if (dp[houseIndex][color][previousColor][previousCount] != 0) {
            return dp[houseIndex][color][previousColor][previousCount];
        }
        if (previousCount == target && houseIndex == m) {
            return 0;
        }
        if (houseIndex >= m || previousCount > target || houses[houseIndex] != 0 && color != houses[houseIndex]) {
            dp[houseIndex][color][previousColor][previousCount] = Integer.MAX_VALUE;
            return Integer.MAX_VALUE;
        }
        if (houses[houseIndex] != 0) {
            int currentCount = previousCount;
            if (previousColor != color) {
                currentCount++;
            }
            int minCount = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int count = function(houses, cost, m, n, target, houseIndex + 1, i + 1, color, currentCount);
                minCount = Math.min(minCount, count);
            }
            dp[houseIndex][color][previousColor][previousCount] = minCount;
            return minCount;
        } else {
            int currentCount = previousCount;
            if (previousColor != color) {
                currentCount++;
            }
            int minCount = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int count = function(houses, cost, m, n, target, houseIndex + 1, i + 1, color, currentCount);
                if (count == Integer.MAX_VALUE) {
                    continue;
                }
                count += cost[houseIndex][color - 1];
                minCount = Math.min(minCount, count);
            }
            dp[houseIndex][color][previousColor][previousCount] = minCount;
            return minCount;
        }
    }
}
