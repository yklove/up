package cn.yklove.leetcode.contest.weekly190;

import java.util.Map;

/**
 * @author qinggeng
 */
public class LeetCode4 {

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        dp[0][0] = nums1[0] * nums2[0];
        for (int i = 1; i < nums1.length; i++) {
            dp[i][0] = Math.max(nums1[i] * nums2[0], dp[i - 1][0]);
        }
        for (int i = 1; i < nums2.length; i++) {
            dp[0][i] = Math.max(nums1[0] * nums2[i], dp[0][i - 1]);
        }
        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums2.length; j++) {
                dp[i][j] = Math.max(nums1[i] * nums2[j],Math.max(dp[i - 1][j - 1], Math.max(nums1[i] * nums2[j] + dp[i - 1][j - 1], Math.max(dp[i - 1][j], dp[i][j - 1]))));
            }
        }
        return dp[nums1.length - 1][nums2.length - 1];
    }

    public int maxDotProduct2(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                dp[i][j] = Math.max(dp[i][j], Math.max(0, dp[i - 1][j - 1]) + nums1[i - 1] * nums2[j - 1]);
            }
        }
        return dp[nums1.length][nums2.length];
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode4().maxDotProduct(new int[]{-3, -8, 3, -10, 1, 3, 9}, new int[]{
                9, 2, 3, 7, -9, 1, -8, 5, -1, -1}));
    }
}
