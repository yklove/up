package cn.yklove.leetcode;

import java.util.Objects;
import java.util.Stack;

public class LeetCode0020 {


    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && ((Objects.equals(c, '}') && Objects.equals('{', stack.peek())) ||
                    (Objects.equals(c, ')') && Objects.equals('(', stack.peek())) ||
                    (Objects.equals(c, ']') && Objects.equals('[', stack.peek())))
            ) {
                stack.pop();
            } else {
                stack.add(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode0020().isValid("()"));
        System.out.println(new LeetCode0020().isValid("()[]{}"));
        System.out.println(new LeetCode0020().isValid("(]"));
        System.out.println(new LeetCode0020().isValid("([)]"));
        System.out.println(new LeetCode0020().isValid("{[]}"));
    }
}
