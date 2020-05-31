package cn.yklove.leetcode.contest.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author qinggeng
 */
public class LeetCode4 {
    int[][] dp2;
    public int xymod(int a, int b) {
        if(dp2[a][b] != 0){
            return dp2[a][b];
        }
        if (a < b) {
            int temp;
            temp = a;
            a = b;
            b = temp;
        }
        if (0 == b) {
            return a;
        }
        int xymod = xymod(a - b, b);
        dp2[a][b] = xymod;
        return xymod;
    }

    public int splitArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp2 = new int[10000000][10000000];
        dp[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] + 1;
            for (int j = nums.length - 1; j > i; j--) {
                // 求公约数
                int xymod = xymod(nums[i], nums[j]);
                if (xymod > 1) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        return dp[0];
    }

    int[][] dp;

    private int fun(int[] nums, int current, int n) {
        if (dp[current][n] != 0) {
            return dp[current][n];
        }
        if (current == nums.length) {
            return n;
        }
        List<Integer> list = new ArrayList<>();
        // 自己
        list.add(fun(nums, current + 1, n + 1));
        for (int i = current + 1; i < nums.length; i++) {
            int xymod = xymod(nums[current], nums[i]);
            if (xymod > 1) {
                list.add(fun(nums, i + 1, n + 1));
            }
        }
        Collections.sort(list);
        dp[current][n] = list.get(0);
        return list.get(0);
    }

    public static void main(String[] args) {
        LeetCode4 leetCode4 = new LeetCode4();
        System.out.println(leetCode4.splitArray(new int[]{2, 3, 3, 2, 3, 3}));
        System.out.println(leetCode4.splitArray(new int[]{2, 3, 5, 7}));
    }
}
