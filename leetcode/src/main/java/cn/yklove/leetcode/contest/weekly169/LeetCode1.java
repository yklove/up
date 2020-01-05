package cn.yklove.leetcode.contest.weekly169;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    public int[] sumZero(int n) {
        if (n == 1) {
            return new int[]{0};
        }
        int[] ans = new int[n];
        int current = 0;
        for (; current < n-1; current += 2) {
            ans[current] = current + 1;
            ans[current + 1] = -(current + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        for (int i : new LeetCode1().sumZero(5)) {
            System.out.print(i + " ");
        }
    }
}
