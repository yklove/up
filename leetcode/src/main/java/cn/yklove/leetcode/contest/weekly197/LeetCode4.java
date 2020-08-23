package cn.yklove.leetcode.contest.weekly197;

import java.util.Map;

/**
 * @author qinggeng
 */
public class LeetCode4 {

    public double getMinDistSum(int[][] positions) {
        double x = 0;
        double y = 0;
        for (int[] position : positions) {
            x += position[0];
            y += position[1];
        }
        double x1 = x / (double) positions.length;
        double y1 = y / (double) positions.length;
        double sum = 0;
        for (int[] position : positions) {
            sum += Math.sqrt((x1 - position[0]) * (x1 - position[0]) + (y1 - position[1]) * (y1 - position[1]));
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode4().getMinDistSum(new int[][]{{1,1},{0,0},{2,0}}));
//        System.out.println(new LeetCode4().getMinDistSum(new int[][]{{1, 1}, {3, 3}}));
    }
}
