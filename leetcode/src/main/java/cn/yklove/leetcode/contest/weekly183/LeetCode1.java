package cn.yklove.leetcode.contest.weekly183;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int sumAns = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            sumAns += nums[i];
            ans.add(nums[i]);
            if (sumAns > sum - sumAns) {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode1().minSubsequence(new int[]{4, 3, 10, 9, 8}));
        System.out.println(new LeetCode1().minSubsequence(new int[]{4, 4, 7, 6, 7}));
        System.out.println(new LeetCode1().minSubsequence(new int[]{6}));
    }
}
