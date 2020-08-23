package cn.yklove.leetcode.contest.weekly201;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    public String makeGood(String s) {
        while (true) {
            boolean key = true;
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1) + 32 || s.charAt(i) == s.charAt(i + 1) - 32) {
                    s = s.substring(0, i) + s.substring(i + 2);
                    key = false;
                    break;
                }
            }
            if(key){
                return s;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode1().makeGood("leEeetcode"));
        System.out.println(new LeetCode1().makeGood("abBAcC"));
        System.out.println(new LeetCode1().makeGood("s"));
    }
}
