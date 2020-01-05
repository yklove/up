package cn.yklove.leetcode;

/**
 * @author qinggeng
 */
public class LeetCode0053 {

    public int maxSubArray(int[] nums) {
        int tmp = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            tmp = Math.max(num,num+tmp);
            max = Math.max(tmp,max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode0053().maxSubArray(new int[]{1}));
        System.out.println(new LeetCode0053().maxSubArray(new int[]{-1}));
        System.out.println(new LeetCode0053().maxSubArray(new int[]{-3, -1, -2}));
        System.out.println(new LeetCode0053().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

}
