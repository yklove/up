package cn.yklove.leetcode;

import java.util.Arrays;

/**
 * @author qinggeng
 * @date 2020-01-09
 */
public class LeetCode0064 {
    public static void main(String[] args) {
        System.out.println(new LeetCode0064().minPathSum(
                new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}
        ));
        System.out.println(new LeetCode0064().minPathSum(
                new int[][]{{1}}
        ));
    }


    private int dp(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        // 最后一个位置
        dp[grid.length - 1][grid[0].length - 1] = grid[grid.length - 1][grid[0].length - 1];
        // 最后一行
        for (int i = grid[0].length - 2; i >= 0; i--) {
            dp[grid.length - 1][i] = dp[grid.length - 1][i + 1] + grid[grid.length - 1][i];
        }
        // 最后一列
        for (int i = grid.length - 2; i >= 0; i--) {
            dp[i][grid[0].length - 1] = dp[i + 1][grid[0].length - 1] + grid[i][grid[0].length - 1];
        }
        for (int i = grid.length - 2; i >= 0; i--) {
            for (int j = grid[0].length - 2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i][j + 1], dp[i + 1][j]) + grid[i][j];
            }
        }
        return dp[0][0];
    }

    public int minPathSum(int[][] grid) {
//        storage = new int[grid.length][grid[0].length];
//        for (int[] ints : storage) {
//            Arrays.fill(ints, -1);
//        }
//        return process(grid, 0, 0);
//        return dp(grid);
        return dp(grid);
    }

    private int[][] storage;

    /**
     * 当前位置在row行，col列，返回到达右下角的最小路径
     */
    private int process(int[][] grid, int row, int col) {
        if (storage[row][col] != -1) {
            return storage[row][col];
        }
        // 当前位置在右下角，最小路径是当前位置的数字
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            storage[row][col] = grid[row][col];
            return storage[row][col];
        }
        // 当前位置在最后一列，最小路径是当前位置的数字+右边的最小路径
        if (row == grid.length - 1) {
            storage[row][col] = grid[row][col] + process(grid, row, col + 1);
            return storage[row][col];
        }
        // 当前位置在最后一行，最小路径是当前位置的数字+下边的最小路径
        if (col == grid[0].length - 1) {
            storage[row][col] = grid[row][col] + process(grid, row + 1, col);
            return storage[row][col];
        }
        // 其余情况，最小路径是当前位置的数字+右侧或者下侧两者中最小的最小路径
        storage[row][col] = grid[row][col] + Math.min(process(grid, row, col + 1), process(grid, row + 1, col));
        return storage[row][col];
    }
}
