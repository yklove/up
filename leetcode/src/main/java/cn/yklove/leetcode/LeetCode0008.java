package cn.yklove.leetcode;

/**
 * @author qinggeng
 * @date 2019/12/28
 */
public class LeetCode0008 {

    public int myAtoi(String str) {
        StringBuilder stringBuilder = clearString(str);
        if (stringBuilder.length() == 0 || !checkNumber(stringBuilder)) {
            return 0;
        }
        char symbol = stringBuilder.charAt(0);
        if (symbol == '+') {
            stringBuilder.deleteCharAt(0);
        }
        try {
            return Integer.parseInt(stringBuilder.toString());
        } catch (Exception e) {
            if (symbol == '-') {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }

    private boolean checkNumber(StringBuilder stringBuilder) {
        // 可能是符号位
        char symbol = stringBuilder.charAt(0);
        if (symbol == '+' || symbol == '-') {
            if (stringBuilder.length() == 1) {
                return false;
            }
            char number = stringBuilder.charAt(1);
            return number >= '0' && number <= '9';
        }
        return true;
    }

    private StringBuilder clearString(String str) {
        char[] chars = str.toCharArray();
        int i = 0;

        StringBuilder stringBuilder = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            if (c == '-' || c == '+' || (c >= '0' && c <= '9')) {
                stringBuilder.append(c);
                continue;
            }
            break;
        }
        return stringBuilder;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode0008().myAtoi(Integer.MAX_VALUE + ""));
        System.out.println(new LeetCode0008().myAtoi("2147483648"));
        System.out.println(new LeetCode0008().myAtoi(Integer.MIN_VALUE + ""));
        System.out.println(new LeetCode0008().myAtoi("-2147483649"));
        System.out.println(new LeetCode0008().myAtoi("42"));
        System.out.println(new LeetCode0008().myAtoi("+42"));
        System.out.println(new LeetCode0008().myAtoi("    -42"));
        System.out.println(new LeetCode0008().myAtoi("4193 with words"));
        System.out.println(new LeetCode0008().myAtoi("words and 987"));
        System.out.println(new LeetCode0008().myAtoi("-91283472332"));
        System.out.println(new LeetCode0008().myAtoi("--91283472332"));
        System.out.println(new LeetCode0008().myAtoi("++91283472332"));
        System.out.println(new LeetCode0008().myAtoi("   +0 123"));
    }

}
