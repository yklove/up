package cn.yklove.leetcode;

/**
 * @author qinggeng
 */
public class LeetCode0200 {

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            char[] chars = grid[i];
            for (int j = 0; j < chars.length; j++) {
                char aChar = chars[j];
                if (aChar == '1') {
                    count++;
                    f(grid, i, j);
                }
            }
        }
        return count;
    }

    private void f(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length) {
            return;
        }
        if (y < 0 || y >= grid[0].length) {
            return;
        }
        if (grid[x][y] == '1') {
            grid[x][y] = 'x';
            f(grid, x, y + 1);
            f(grid, x, y - 1);
            f(grid, x + 1, y);
            f(grid, x - 1, y);
        }
    }

    public static void main(String[] args) {

    }
}
