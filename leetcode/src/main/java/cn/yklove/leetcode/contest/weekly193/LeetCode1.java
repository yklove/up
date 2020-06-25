package cn.yklove.leetcode.contest.weekly193;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    public int[] runningSum(int[] nums) {
        int count = 0;
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i] + count;
            count += nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
