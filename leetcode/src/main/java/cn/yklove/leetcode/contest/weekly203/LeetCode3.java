package cn.yklove.leetcode.contest.weekly203;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        return recursionBinarySearch(arr, m, 0, arr.length);
    }

    public static int recursionBinarySearch(int[] arr, int key, int low, int high) {
        if (low > high) {
            return -1;
        }
        int[] tmps = new int[arr.length];
        for (int i = 0; i < key; i++) {
            tmps[arr[i]] = 1;
        }
        int max = 0;
        int count = 0;
        for (int i : tmps) {
            if (i == 1) {
                count++;
            } else {
                max = Math.max(count, max);
                count = 0;
            }
        }
        int middle = (low + high) / 2;            //初始中间位置
        if (max > key) {
            //比关键字大则关键字在左区域
            return recursionBinarySearch(arr, key, low, middle - 1);
        } else {
            //比关键字小则关键字在右区域
            return recursionBinarySearch(arr, key, middle + 1, high);
        }

    }


    public static void main(String[] args) {
        System.out.println(new LeetCode3().findLatestStep(new int[]{3, 5, 1, 2, 4}, 1));
        ;
    }
}
