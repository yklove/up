package cn.yklove.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author qinggeng
 */
public class LeetCode0055 {

    public boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        for (int i = 0; i < nums.length - 1; ) {
            int max = Integer.MIN_VALUE;
            int maxIndex = -1;
            for (int j = i + 1; j <= i + nums[i]; j++) {
                if (j == nums.length - 1) {
                    return true;
                }
                if (nums[j] + j >= max) {
                    max = nums[j] + j;
                    maxIndex = j;
                }
            }
            i = maxIndex;
            if (i == -1) {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode0055 leetCode0055 = new LeetCode0055();
        System.out.println(leetCode0055.canJump(new int[]{0}));
        System.out.println(leetCode0055.canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(leetCode0055.canJump(new int[]{2, 3, 1, 1, 4}));
    }
}
