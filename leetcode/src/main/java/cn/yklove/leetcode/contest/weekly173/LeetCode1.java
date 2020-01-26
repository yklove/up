package cn.yklove.leetcode.contest.weekly173;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    public int removePalindromeSub(String s) {
        if("".equals(s)){
            return 0;
        }
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder(s);
        while (!"".equals(stringBuilder.toString())){
            count++;
            String s1 = longestPalindrome(stringBuilder.toString());
            stringBuilder.replace(stringBuilder.indexOf(s1),stringBuilder.indexOf(s1)+s1.length(), "");
        }
        return count >= 2 ? 2:1;
    }

    public String longestPalindrome(String s) {
        if (s == null) {
            return "";
        }
        s = process(s);
        int r = -1;
        int c = -1;
        int max = Integer.MIN_VALUE;
        int iMax = 0;
        StringBuilder stringBuilder;
        int[] rArray = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            rArray[i] = r <= i ? 1 : Math.min(rArray[2 * c - i], r - i);
            while (i + rArray[i] < s.length() && i - rArray[i] > -1) {
                if (s.charAt(i + rArray[i]) == s.charAt(i - rArray[i])) {
                    rArray[i]++;
                } else {
                    break;
                }
            }
            if (i + rArray[i] > r) {
                r = i + rArray[i];
                c = i;
            }
            if (rArray[i] > max) {
                max = rArray[i];
                iMax = i;
            }
        }
        stringBuilder = new StringBuilder();
        for (int j = iMax - max + 1; j < iMax + max; j++) {
            if ('#' != s.charAt(j)) {
                stringBuilder.append(s.charAt(j));
            }
        }
        return stringBuilder.toString();
    }

    private static String process(String s) {
        StringBuilder stringBuilder = new StringBuilder("#");
        for (char c : s.toCharArray()) {
            stringBuilder.append(c).append("#");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode1().removePalindromeSub("bbaabaaa"));
        System.out.println(new LeetCode1().removePalindromeSub("ababa"));
        System.out.println(new LeetCode1().removePalindromeSub("abb"));
        System.out.println(new LeetCode1().removePalindromeSub("baabb"));
        System.out.println(new LeetCode1().removePalindromeSub(""));
    }
}
