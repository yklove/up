package cn.yklove.leetcode.contest.weekly192;

/**
 * @author qinggeng
 */
public class LeetCode1 {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        int count = 0;
        for (int i = 0; i < nums.length; i += 2) {
            ans[i] = nums[count];
            ans[i + 1] = nums[count + n];
            count++;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
