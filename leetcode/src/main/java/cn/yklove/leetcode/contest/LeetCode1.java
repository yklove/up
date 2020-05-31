package cn.yklove.leetcode.contest;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    public int minCount(int[] coins) {
        int count = 0;
        for (int coin : coins) {
            count+=coin/2;
            count+=coin%2;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode1().minCount(new int[]{2,3,10}));
    }
}
