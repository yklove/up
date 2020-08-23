package cn.yklove.leetcode.contest.weekly203;

import java.util.Arrays;

/**
 * @author qinggeng
 */
public class LeetCode2 {

//    2,4,1,2,7,8
//    1 2 2 4 7 8
//    1 7 8

    public int maxCoins(int[] piles) {
        int ans = 0;
        int end = piles.length - 1;
        int start = 0;
        Arrays.sort(piles);
        int count = 0;
        while (count * 3 != piles.length) {
            ans += piles[end - 1];
            end -= 2;
            start++;
            count++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode2().maxCoins(new int[]{2, 4, 1, 2, 7, 8}));
        System.out.println(new LeetCode2().maxCoins(new int[]{2, 4, 5}));
        System.out.println(new LeetCode2().maxCoins(new int[]{9, 8, 7, 6, 5, 1, 2, 3, 4}));
    }

}
