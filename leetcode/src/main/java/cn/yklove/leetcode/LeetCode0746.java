package cn.yklove.leetcode;

/**
 * @author qinggeng
 */
public class LeetCode0746 {
    public int minCostClimbingStairs(int[] cost) {
        for (int i = 0; i < cost.length; i++) {
            cost[i] = Math.min(get(cost, i - 1) + cost[i], get(cost, i - 2) + cost[i]);
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }

    private int get(int[] cost, int i) {
        if (i < 0 || i >= cost.length) {
            return 0;
        }
        return cost[i];
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode0746().minCostClimbingStairs(new int[]{10, 15, 30}));
        System.out.println(new LeetCode0746().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
