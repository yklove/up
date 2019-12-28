package cn.yklove.leetcode;

/**
 * @author qinggeng
 * @date 2019/12/28
 */
public class LeetCode007 {

    public int reverse(int x) {
        StringBuilder xString = new StringBuilder(String.valueOf(Math.abs(x)));
        StringBuilder stringBuilder = xString.reverse();
        for (int i = 10 - stringBuilder.length(); i > 0; i--) {
            stringBuilder.insert(0, "0");
        }
        String reverse = stringBuilder.toString();
        if (x >= 0) {
            return reverse.compareTo(String.valueOf(Integer.MAX_VALUE)) > 0 ? 0 : Integer.parseInt(reverse);
        } else {
            return reverse.compareTo(String.valueOf(Integer.MIN_VALUE).substring(1)) > 0 ? 0 : -1 * Integer.parseInt(reverse);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode007().reverse(Integer.MAX_VALUE));
        System.out.println(new LeetCode007().reverse(Integer.MIN_VALUE));
        System.out.println(new LeetCode007().reverse(123));
        System.out.println(new LeetCode007().reverse(-123));
        System.out.println(new LeetCode007().reverse(120));
    }

}
