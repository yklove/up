package cn.yklove.leetcode.contest.weekly191;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                ans = Math.max(ans, (nums[i] - 1) * (nums[j] - 1));
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
