package cn.yklove.leetcode.contest.weekly181;

/**
 * @author qinggeng
 */
public class LeetCode4 {

    private int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[]{-1,0};
        }
        int[] next = new int[ms.length+1];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < next.length) {
            if (ms[i - 1] == ms[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }

    public String longestPrefix(String s) {
        char[] chars = s.toCharArray();
        int[] nextArray = getNextArray(chars);
        return s.substring(0, nextArray[s.length()]);
    }

    public static void main(String[] args) {
        LeetCode4 leetCode4 = new LeetCode4();
        System.out.println(leetCode4.longestPrefix("bba"));
        System.out.println(leetCode4.longestPrefix("babbb"));
        System.out.println(leetCode4.longestPrefix("level"));
        System.out.println(leetCode4.longestPrefix("ababab"));
        System.out.println(leetCode4.longestPrefix("leetcodeleet"));
        System.out.println(leetCode4.longestPrefix("a"));
        System.out.println(leetCode4.longestPrefix("leetcode"));
    }

}
