package cn.yklove.leetcode.L0062;

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] map = new int[m + 1][n + 1];
        map[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = map[i][j] + map[i][j - 1] + map[i - 1][j];
            }
        }
        return map[m][n];
    }
}