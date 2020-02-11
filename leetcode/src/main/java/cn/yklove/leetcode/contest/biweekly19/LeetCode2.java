package cn.yklove.leetcode.contest.biweekly19;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qinggeng
 */
public class LeetCode2 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        for (int i = 0; i < arr.length - k + 1; i++) {
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += arr[i + j];
            }
            if (sum / k >= threshold) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        LeetCode2 leetCode2 = new LeetCode2();
        System.out.println(leetCode2.numOfSubarrays(new int[]{2, 2, 2, 2, 5, 5, 5, 8}, 3, 4));
        System.out.println(leetCode2.numOfSubarrays(new int[]{1,1,1,1,1}, 1, 0));
    }
}
