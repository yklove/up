package cn.yklove.leetcode.contest.weekly190;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] s = sentence.split(" ");
        for (int i = 0; i < s.length; i++) {
            String s1 = s[i];
            if (s1.startsWith(searchWord)) {
                return i+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
