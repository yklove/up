package cn.yklove.leetcode.contest.weekly171;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            if (noZeor(i) && noZeor(n-i)){
                return new int[]{i,n-i};
            }
        }
        return new int[]{0,0};
    }

    private boolean noZeor(int n) {
        while (n != 0) {
            if (n % 10 == 0) {
                return false;
            }
            n = n / 10;
        }
        return true;
    }

    public static void main(String[] args) {
        for (int noZeroInteger : new LeetCode1().getNoZeroIntegers(69)) {
            System.out.print(noZeroInteger + " ");
        }
    }
}
