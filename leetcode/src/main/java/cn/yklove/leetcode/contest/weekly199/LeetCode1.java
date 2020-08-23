package cn.yklove.leetcode.contest.weekly199;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    public String restoreString(String s, int[] indices) {
        char[] ans = new char[indices.length];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            ans[indices[i]] = chars[i];
        }
        return new String(ans);
    }

    public static void main(String[] args) {

    }
}
