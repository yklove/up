package cn.yklove.leetcode.interview;

/**
 * @author qinggeng
 */
public class LeetCode1607 {
    public int maximum(int a, int b) {
        long dif = (long) a - (long) b;
        int k = (int) (dif >>> 63);
        return a * (k ^ 1) + b * k;
    }

    public static void main(String[] args) {
        LeetCode1607 leetCode1607 = new LeetCode1607();
        System.out.println(leetCode1607.maximum(1, 2));
        System.out.println(leetCode1607.maximum(2147483647, -2147483648));
    }
}
