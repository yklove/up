package cn.yklove.leetcode;

/**
 * @author qinggeng
 */
public class LeetCode0151 {

    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] s1 = s.trim().split(" ");
        for (int i = s1.length - 1; i >= 0; i--) {
            if(!s1[i].trim().equals("")){
                stringBuilder.append(s1[i]).append(" ");
            }
        }
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode0151().reverseWords("the sky is blue"));
        System.out.println(new LeetCode0151().reverseWords("  hello world!  "));
        System.out.println(new LeetCode0151().reverseWords("a good   example"));
    }
}
