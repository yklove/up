package cn.yklove.leetcode;

import java.util.*;

/**
 * @author qinggeng
 */
public class LeetCode0131 {

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        f(s, ans, new Stack<>());
        if(isPalindromeString(s)){
            ans.add(Collections.singletonList(s));
        }
        return ans;
    }

    private void f(String s, List<List<String>> ans, Stack<String> tmp) {
        int length = s.length();
        for (int i = 1; i < length; i++) {
            String x = s.substring(0, i);
            if (!isPalindromeString(x)) {
                continue;
            }
            tmp.push(x);
            String y = s.substring(i, length);
            if (isPalindromeString(y)) {
                tmp.push(y);
                ans.add(new ArrayList<>(tmp));
                tmp.pop();
            }
            f(y, ans, tmp);
            tmp.pop();
        }
    }

    private boolean isPalindromeString(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            if (chars[start++] != chars[end--]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode0131 leetCode0131 = new LeetCode0131();
        System.out.println(leetCode0131.partition("a"));
        System.out.println(leetCode0131.partition("aa"));
        System.out.println(leetCode0131.partition("aab"));
        System.out.println(leetCode0131.partition("aaaa"));
    }

}
