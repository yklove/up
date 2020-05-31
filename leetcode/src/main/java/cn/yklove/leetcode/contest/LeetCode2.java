package cn.yklove.leetcode.contest;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    private int count = 0;
    private int[][] relation;
    private int n;

    public int numWays(int n, int[][] relation, int k) {
        count = 0;
        this.relation = relation;
        this.n = n;
        fun(0, k);
        return count;
    }

    private void fun(int current, int k) {
        if (k == 0 && current == n - 1) {
            count++;
        }
        if (k < 0) {
            return;
        }
        for (int[] ints : relation) {
            if (ints[0] == current) {
                fun(ints[1], k-1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode2().numWays(5, new int[][]{{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}}, 3));
        System.out.println(new LeetCode2().numWays(3, new int[][]{{0, 2}, {2, 1}}, 2));
    }
}
