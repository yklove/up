package cn.yklove.leetcode;

/**
 * @author qinggeng
 */
public class LeetCode0300 {

    public int lengthOfLIS(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    int tmp = dp[j];
                    tmp += 1;
                    max = Math.max(max, tmp);
                }
            }
            dp[i] = max;
            ans = Math.max(ans,max);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode0300().lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
        System.out.println(new LeetCode0300().lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));
        System.out.println(new LeetCode0300().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

}
