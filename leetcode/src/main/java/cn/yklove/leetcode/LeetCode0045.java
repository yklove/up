package cn.yklove.leetcode;

/**
 * @author qinggeng
 */
public class LeetCode0045 {

    public int jump(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; ) {
            count++;
            int max = Integer.MIN_VALUE;
            int maxIndex = -1;
            for (int j = i + 1; j <= i + nums[i]; j++) {
                if (j == nums.length - 1) {
                    return count;
                }
                if (nums[j] + j >= max) {
                    max = nums[j] + j;
                    maxIndex = j;
                }
            }
            i = maxIndex;
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode0045().jump(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 0}));
        System.out.println(new LeetCode0045().jump(new int[]{2, 3, 1}));
        System.out.println(new LeetCode0045().jump(new int[]{3, 2, 1}));
        System.out.println(new LeetCode0045().jump(new int[]{2, 3, 1, 1, 4}));
    }
}
