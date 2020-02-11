package cn.yklove.leetcode.contest.weekly175;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    public int minSteps(String s, String t) {
        int[] a = new int[26];
        int[] b = new int[26];
        for (char c : s.toCharArray()) {
            a[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            b[c - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                count += (Math.max((a[i] - b[i]), 0));
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode2 leetCode2 = new LeetCode2();
        System.out.println(leetCode2.minSteps("bab", "aba"));
        System.out.println(leetCode2.minSteps("leetcode", "practice"));
        System.out.println(leetCode2.minSteps("anagram", "mangaar"));
    }
}
