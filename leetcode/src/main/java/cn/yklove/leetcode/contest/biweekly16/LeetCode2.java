package cn.yklove.leetcode.contest.biweekly16;

/**
 * @author qinggeng
 * @date 2019/12/28
 */
public class LeetCode2 {

    public int findBestValue(int[] arr, int target) {
        int start = target / arr.length;
        int min = Integer.MAX_VALUE;
        int ans = start;
        int max = max(arr);
        for (int i = start; i <= max; i++) {
            int sum = 0;
            for (int value : arr) {
                sum += Math.min(i, value);
            }
            if (Math.abs(sum - target) < min) {
                ans = i;
                min = Math.abs(sum - target);
            }
        }
        return ans;
    }

    private int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode2().findBestValue(new int[]{4, 9, 3}, 10));
        System.out.println(new LeetCode2().findBestValue(new int[]{2, 3, 5}, 10));
        System.out.println(new LeetCode2().findBestValue(new int[]{60864,25176,27249,21296,20204}, 56803));
    }
}
