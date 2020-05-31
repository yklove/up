package cn.yklove.leetcode.contest.weekly191;

import java.util.Arrays;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long[] x = new long[horizontalCuts.length + 1];
        long[] y = new long[verticalCuts.length + 1];
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        init(h, horizontalCuts, x);
        init(w, verticalCuts, y);
        long maxX = Integer.MIN_VALUE;
        long maxY = Integer.MIN_VALUE;
        for (long i : x) {
            maxX = Math.max(maxX, i);
        }
        for (long i : y) {
            maxY = Math.max(maxY, i);
        }
        return (int) ((maxX * maxY) % (1000000000 + 7));
    }

    private void init(int w, int[] cuts, long[] result) {
        result[0] = cuts[0];
        for (int i = 1; i < cuts.length; i++) {
            result[i] = cuts[i] - cuts[i - 1];
        }
        result[cuts.length] = w - cuts[cuts.length - 1];
    }

    public static void main(String[] args) {
        LeetCode2 leetCode2 = new LeetCode2();
        System.out.println(leetCode2.maxArea(5, 4, new int[]{3, 1}, new int[]{1}));
    }
}
