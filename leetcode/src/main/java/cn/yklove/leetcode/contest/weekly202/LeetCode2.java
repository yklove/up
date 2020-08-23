package cn.yklove.leetcode.contest.weekly202;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    public int minOperations(int n) {
        int x = n / 2;
        int count = x * 2 + 1;
        if (n % 2 == 0) {
            count -= 1;
        }
        int ans = 0;
        for (int i = 0; i < n / 2; i++) {
            int tmp = i * 2 + 1;
            ans += (count - tmp);
        }
        return ans;
    }

    public static void main(String[] args) {
        // 1 3 5 7 9 11
        System.out.println(new LeetCode2().minOperations(6));
        System.out.println(new LeetCode2().minOperations(3));
    }
}
