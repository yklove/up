package cn.yklove.leetcode.contest.weekly172;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    public List<String> printVertically(String s) {
        List<String> list = new ArrayList<>();
        String[] s1 = s.split(" ");
        char[][] x = new char[200][200];
        for (char[] chars : x) {
            Arrays.fill(chars, ' ');
        }
        int length = 0;
        for (int i = 0; i < s1.length; i++) {
            char[] chars = s1[i].toCharArray();
            length = Math.max(length,chars.length);
            for (int i1 = 0; i1 < chars.length; i1++) {
                x[i1][i] = chars[i1];
            }
        }
        for (int i = 0; i < length; i++) {
            list.add(trimEnd(x[i]));
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode2().printVertically("HOW ARE YOU"));
        for (String s : new LeetCode2().printVertically("TO BE OR NOT TO BE")) {
            System.out.println(s);
        }
    }

    public String trimEnd(char[] value) {
        int len = value.length;
        int st = 0;
        char[] val = value;
        while ((st < len) && (val[len - 1] <= ' ')) {
            len--;
        }
        return ((st > 0) || (len < value.length)) ? new String(val).substring(st, len) : new String(val);
    }
}
