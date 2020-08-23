package cn.yklove.leetcode.L0322;

import java.util.Arrays;

class Solution {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        return recursion(coins, coins.length - 1, amount);
    }

    /**
     * @param index  -1 ~ coins.length-1
     * @param amount 0 ~ amount
     */
    private int recursion(int[] coins, int index, int amount) {
        if (amount == 0) {
            return 1;
        }
        if (index < 0) {
            return 0;
        }
        for (int i = amount / coins[index]; i >= 0; i--) {
            if (amount - i * coins[index] == 0) {
                return i;
            }
            int recursion = recursion(coins, index - 1, amount - i * coins[index]);
            if (recursion > 0) {
                return recursion + i;
            }
        }
        return -1;
    }

}