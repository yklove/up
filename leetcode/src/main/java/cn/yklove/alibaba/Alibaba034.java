package cn.yklove.alibaba;

/**
 * @author qinggeng
 */
public class Alibaba034 {

    public int solution(int[][] m) {
        int[][] dp = new int[m.length][m.length];
        dp[0][0] = m[0][0];
        for (int i = 1; i < m.length; i++) {
            dp[i][0] = m[i][0] + dp[i - 1][0];
            dp[0][i] = m[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < m.length; i++) {
            for (int j = 1; j < m.length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
            }
        }
        return dp[m.length - 1][m.length - 1];
    }

    public static void main(String[] args) {
        Alibaba034 alibaba034 = new Alibaba034();
        System.out.println(alibaba034.solution(new int[][]{
                {4, 1, 5, 3},
                {3, 2, 7, 7},
                {6, 5, 2, 8},
                {8, 9, 4, 5}
        }));
    }
}
