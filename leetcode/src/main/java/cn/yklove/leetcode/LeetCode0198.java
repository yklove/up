package cn.yklove.leetcode;

/**
 * @author qinggeng
 */
public class LeetCode0198 {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = 0;
            for (int j = 0; j < i - 1; j++) {
                tmp = Math.max(tmp, dp[j]);
            }
            dp[i] = tmp + nums[i];
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode0198().rob(new int[]{1, 2, 3, 1}));
        System.out.println(new LeetCode0198().rob(new int[]{2, 7, 9, 3, 1}));
    }

}
