package cn.yklove.leetcode.contest.biweekly18;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) {
            return "";
        }
        int count = 0;
        int temp = -1;
        for (int i = 0; i < palindrome.length(); i++) {
            if (palindrome.charAt(i) != 'a' && temp == -1) {
                temp = i;
            }
            if (palindrome.charAt(i) == 'a') {
                count++;
            }
        }
        if (count != palindrome.length() - 1 && temp != -1) {
            return new StringBuilder(palindrome).replace(temp, temp + 1, "a").toString();
        }
        return new StringBuilder(palindrome).replace(palindrome.length() - 1, palindrome.length(), "b").toString();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode2().breakPalindrome("ab"));
        System.out.println(new LeetCode2().breakPalindrome("aba"));
        System.out.println(new LeetCode2().breakPalindrome("abccba"));
        System.out.println(new LeetCode2().breakPalindrome("a"));
        System.out.println(new LeetCode2().breakPalindrome("aacc"));
        System.out.println(new LeetCode2().breakPalindrome("ababa"));
        System.out.println(new LeetCode2().breakPalindrome("aa"));
    }
}
