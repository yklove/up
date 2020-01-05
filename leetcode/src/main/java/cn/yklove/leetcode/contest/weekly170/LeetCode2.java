package cn.yklove.leetcode.contest.weekly170;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    public static void main(String[] args) {
        for (int i : new LeetCode2().xorQueries(
                new int[]{1, 3, 4, 8}
                , new int[][]{{0, 1}, {1, 2}, {0, 3}, {3, 3}})) {
            System.out.print(i + " ");
        }
    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int tmp = 0;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                tmp ^= arr[j];
            }
            ans[i] = tmp;
        }
        return ans;
    }
}
