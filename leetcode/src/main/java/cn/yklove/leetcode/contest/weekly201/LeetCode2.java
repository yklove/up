package cn.yklove.leetcode.contest.weekly201;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    public static void main(String[] args) {
        System.out.println(new LeetCode2().findKthBit(3, 1));
        System.out.println(new LeetCode2().findKthBit(4, 11));
    }

    String[] map;

    public char findKthBit(int n, int k) {
        map = new String[n + 1];
        return process(n).charAt(k - 1);
    }

    private String process(int n) {
        if (n == 1) {
            return "0";
        }
        if (map[n] != null) {
            return map[n];
        }
        String process = process(n - 1);
        char[] chars = process.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '0') {
                stringBuilder.append('1');
            } else {
                stringBuilder.append('0');
            }
        }
        String s = process(n - 1) + "1" + stringBuilder.toString();
        map[n] = s;
        return s;
    }
}
