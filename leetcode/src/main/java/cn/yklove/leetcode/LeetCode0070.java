package cn.yklove.leetcode;

/**
 * @author qinggeng
 */
public class LeetCode0070 {

    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs2(n - 1) + climbStairs2(n - 2);
    }

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] ans = new int[n+1];
        ans[1] = 1;
        ans[2] = 2;
        for(int i=3;i<=n;i++){
            ans[i] = ans[i-1] + ans[i-2];
        }
        return ans[n];
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode0070().climbStairs(1));
        System.out.println(new LeetCode0070().climbStairs(2));
        System.out.println(new LeetCode0070().climbStairs(3));
        System.out.println(new LeetCode0070().climbStairs(4));
        System.out.println(new LeetCode0070().climbStairs(5));
        System.out.println(new LeetCode0070().climbStairs(6));
    }
}
