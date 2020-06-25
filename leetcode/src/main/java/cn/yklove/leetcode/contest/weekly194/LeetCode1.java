package cn.yklove.leetcode.contest.weekly194;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    public int xorOperation(int n, int start) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = start + 2 * i;
        }
        int ans = nums[0];
        for (int i = 1; i < n; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}
