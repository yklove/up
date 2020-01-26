package cn.yklove.leetcode.contest.biweekly18;

import java.util.Map;

/**
 * @author qinggeng
 */
public class LeetCode4 {

    public int maxValueAfterReverse(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int t = (Math.abs(nums[i] - nums[j + 1]) - Math.abs(nums[j] - nums[j + 1])) +
                        ((i - 1 < 0) ? 0 : (Math.abs(nums[i - 1] - nums[i]) - Math.abs(nums[i - 1] - nums[j])));
                max = Math.max(max, t);
            }
        }
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            ans += Math.abs(nums[i] - nums[i + 1]);
        }
        ans += max;
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(new LeetCode4().maxValueAfterReverse(new int[]{2, 3, 1, 5, 4}));
        System.out.println(new LeetCode4().maxValueAfterReverse(new int[]{2, 4, 9, 24, 2, 1, 10}));
    }
}
