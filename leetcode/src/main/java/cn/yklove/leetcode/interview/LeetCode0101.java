package cn.yklove.leetcode.interview;

/**
 * @author qinggeng
 */
public class LeetCode0101 {
    public boolean isUnique(String astr) {
        for (int i = 0; i < astr.length(); i++) {
            String s = astr;
            s = s.replace(String.valueOf(s.charAt(i)), "");
            if (s.length() != astr.length() - 1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode0101 leetCode0101 = new LeetCode0101();
        System.out.println(leetCode0101.isUnique("leetcode"));
        System.out.println(leetCode0101.isUnique("abc"));
    }
}
