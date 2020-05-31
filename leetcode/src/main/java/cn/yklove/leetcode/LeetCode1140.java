package cn.yklove.leetcode;

/**
 * @author qinggeng
 */
public class LeetCode1140 {

    public int stoneGameII(int[] piles) {
        int fun = fun(piles, 1, 0);
        return fun;
    }


    private int fun(int[] piles, int M, int count) {
        if (count == piles.length - 1) {
            return piles[count];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < M * 2; i++) {
            max = Math.max(max, piles[count] + fun(piles, Math.max(M, i), count + i));
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode1140 leetCode1140 = new LeetCode1140();
        System.out.println(10 == leetCode1140.stoneGameII(new int[]{2, 7, 9, 4, 4}));
    }
}
