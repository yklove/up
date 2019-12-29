package cn.yklove.leetcode.contest.biweekly16;

/**
 * @author qinggeng
 * @date 2019/12/28
 */
public class LeetCode2_1 {

    public int findBestValue(int[] arr, int target) {
        int start = target / arr.length;
        int min = Integer.MAX_VALUE;
        int ans = start;
        int max = max(arr);
        while (true) {
            int count = (max - start) / 2;
            int current = count + start;
            int sum = 0;
            for (int i : arr) {
                sum += Math.min(i, current);
            }
            if (Math.abs(sum - target) <= min) {
                ans = current;
                min = Math.abs(sum - target);
            }
            if (sum > target) {
                if (max == current) {
                    break;
                }
                max = current;
            } else if (sum < target) {
                if (start == current) {
                    break;
                }
                start = current + 1;
            } else {
                break;
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
        System.out.println(new LeetCode2_1().findBestValue(new int[]{2, 3, 5}, 10));
        System.out.println(new LeetCode2_1().findBestValue(new int[]{4, 9, 3}, 10));
        System.out.println(new LeetCode2_1().findBestValue(new int[]{2, 3, 5}, 10));
        System.out.println(new LeetCode2_1().findBestValue(new int[]{60864, 25176, 27249, 21296, 20204}, 56803));
    }
}
