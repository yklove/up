package cn.yklove.leetcode;

/**
 * @author qinggeng
 * @date 2020-01-09
 */
public class LeetCode0064 {
    public static void main(String[] args) {
        System.out.println(new LeetCode0064().minPathSum(
                new int[][]{{1,3,1},{1,5,1},{4,2,1}}
        ));
        System.out.println(new LeetCode0064().minPathSum(
                new int[][]{{1}}
        ));
    }

    public int minPathSum(int[][] grid) {
        int[][] ans = new int[grid.length + 1][grid[0].length + 1];
        for(int i=1;i<=grid.length;i++){
            ans[i][1] = ans[i-1][1] + grid[i-1][0];
        }
        for(int i=1;i<=grid[0].length;i++){
            ans[1][i] = ans[1][i-1] + grid[0][i-1];
        }
        for(int i=2;i<=grid.length;i++){
            for(int j=2;j<=grid[0].length;j++){
                ans[i][j] = Math.min(ans[i-1][j],ans[i][j-1]) + grid[i-1][j-1];
            }
        }
        return ans[grid.length][grid[0].length];
    }
}
