package cn.yklove.leetcode.contest.weekly199;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    public int minFlips(String target) {
        int i1 = target.indexOf('1');
        if (i1 < 0) {
            return 0;
        }
        target = target.substring(i1);
        char[] chars = target.toCharArray();
        char tmp = '0';
        int count = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (tmp != chars[i]) {
                tmp = chars[i];
                count++;
            }
        }
        if (chars[chars.length - 1] == '0') {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode2().minFlips("11111"));
        System.out.println(new LeetCode2().minFlips("11000"));
        System.out.println(new LeetCode2().minFlips("10111"));
        System.out.println(new LeetCode2().minFlips("101"));
        System.out.println(new LeetCode2().minFlips("00000"));
        System.out.println(new LeetCode2().minFlips("001011101"));
    }
}
