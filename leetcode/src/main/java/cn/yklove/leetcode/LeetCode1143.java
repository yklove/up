package cn.yklove.leetcode;

/**
 * @author qinggeng
 */
public class LeetCode1143 {

    public static void main(String[] args) {
        System.out.println(new LeetCode1143().longestCommonSubsequence("abcde", "ace"));
        System.out.println(new LeetCode1143().longestCommonSubsequence("abc", "abc"));
        System.out.println(new LeetCode1143().longestCommonSubsequence("abc", "def"));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        char[] text1Char = text1.toCharArray();
        char[] text2char = text2.toCharArray();
        int[][] dp = new int[text1Char.length + 1][text2char.length + 1];
        for (int i = 1; i < text1Char.length + 1; i++) {
            for (int j = 1; j < text2char.length + 1; j++) {
                if (text1Char[i - 1] == text2char[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

}
