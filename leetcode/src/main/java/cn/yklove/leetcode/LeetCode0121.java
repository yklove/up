package cn.yklove.leetcode;

/**
 * @author qinggeng
 */
public class LeetCode0121 {
    public int maxProfit(int[] prices) {
        if(null == prices || prices.length == 0){
            return 0;
        }
        int ans = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = prices.length - 1; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            ans = Math.max(ans, max - prices[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode0121().maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
