package cn.yklove.leetcode.contest.weekly192;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int m = arr[(arr.length - 1) / 2];
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        list.sort((o1, o2) -> {
            int compare = Integer.compare(Math.abs(o2 - m), Math.abs(o1 - m));
            if (compare != 0) {
                return compare;
            }
            return Integer.compare(o2, o1);
        });
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode2 leetCode2 = new LeetCode2();
        System.out.println(leetCode2.getStrongest(new int[]{6,7,11,7,6,8},5));
    }
}
