package cn.yklove.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author qinggeng
 */
public class LeetCode0784 {

    private List<List<Boolean>> res;

    public List<String> letterCasePermutation(String S) {
        char[] chars = S.toCharArray();
        int length = 0;
        for (char aChar : chars) {
            if (aChar >= 'a' && aChar <= 'z' || aChar >= 'A' && aChar <= 'Z') {
                length++;
            }
        }
        List<String> ans = new ArrayList<>();
        res = new ArrayList<>();
        f(new LinkedList<>(), length);
        for (List<Boolean> re : res) {
            StringBuilder stringBuilder = new StringBuilder();
            int index = 0;
            for (char aChar : chars) {
                if (aChar >= 'a' && aChar <= 'z' || aChar >= 'A' && aChar <= 'Z') {
                    if (re.get(index)) {
                        stringBuilder.append(Character.toLowerCase(aChar));
                    } else {
                        stringBuilder.append(Character.toUpperCase(aChar));
                    }
                    index++;
                } else {
                    stringBuilder.append(aChar);
                }
            }
            ans.add(stringBuilder.toString());
        }
        return ans;
    }

    private void f(LinkedList<Boolean> track, int n) {
        if (track.size() == n) {
            res.add(new LinkedList<>(track));
            return;
        }
        track.add(true);
        f(track, n);
        track.removeLast();
        track.add(false);
        f(track, n);
        track.removeLast();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode0784().letterCasePermutation("a1b2"));
        System.out.println(new LeetCode0784().letterCasePermutation("3z4"));
        System.out.println(new LeetCode0784().letterCasePermutation("12345"));
    }
}
