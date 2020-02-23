package cn.yklove.leetcode.contest.weekly176;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    private List<Integer> list;
    private int[] dp = new int[40001];

    public LeetCode2() {
        list = new ArrayList<>();
    }

    public void add(int num) {
        list.add(num);
        dp[list.size() - 1] = num;
        for (int i = list.size() - 2; i >= 0; i--) {
            dp[i] *= num;
        }
    }

    public int getProduct(int k) {
        return dp[list.size() - k];
    }

    public static void main(String[] args) {

    }
}
