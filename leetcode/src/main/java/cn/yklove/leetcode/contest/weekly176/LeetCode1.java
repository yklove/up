package cn.yklove.leetcode.contest.weekly176;

/**
 * @author qinggeng
 */
public class LeetCode1 {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] ints : grid) {
            for (int anInt : ints) {
                if(anInt < 0){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
