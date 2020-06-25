package cn.yklove.leetcode.contest.weekly193;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k) {
            return -1;
        }
        int max = Integer.MIN_VALUE;
        for (int i : bloomDay) {
            max = Math.max(i, max);
        }
        int top = max;
        int ans = max / 2;
        int min = 0;
        int ananans = ans;
        while (min <= top) {
            int count = count(bloomDay, ans, k);
            if (count < m) {
                min = ans + 1;
                ans = min + (int) Math.ceil((top - min) / 2.0);
            } else {
                ananans = ans;
                top = ans - 1;
                ans = (int) Math.ceil((top - min) / 2.0) + min;
            }
        }
        return ananans;
    }

    private int count(int[] bloomDay, int x, int k) {
        int count = 0;
        int ans = 0;
        for (int i : bloomDay) {
            if (i <= x) {
                count++;
            } else {
                count = 0;
            }
            if (count >= k) {
                ans++;
                count = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode3().minDays(new int[]{1, 10, 3, 10, 2}, 3, 1));
        System.out.println(new LeetCode3().minDays(new int[]{1, 10, 3, 10, 2}, 3, 2));
        System.out.println(new LeetCode3().minDays(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3));
        System.out.println(new LeetCode3().minDays(new int[]{1000000000, 1000000000}, 1, 1));
        System.out.println(new LeetCode3().minDays(new int[]{1, 10, 2, 9, 3, 8, 4, 7, 5, 6}, 4, 2));
    }
}
