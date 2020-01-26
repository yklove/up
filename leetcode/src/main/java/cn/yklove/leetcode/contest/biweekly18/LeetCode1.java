package cn.yklove.leetcode.contest.biweekly18;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    public int[] arrayRankTransform(int[] arr) {
        int[] tmp = new int[arr.length];
        System.arraycopy(arr, 0, tmp, 0, arr.length);
        Arrays.sort(tmp);
        Map<Integer, Integer> map = new HashMap<>();
        int count = 1;
        int pre = Integer.MAX_VALUE;
        for (int value : tmp) {
            map.putIfAbsent(value, count);
            if(pre != value) {
                count++;
            }
            pre = value;
        }
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = map.get(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        new LeetCode1().arrayRankTransform(new int[]{100, 100, 100,200});
        new LeetCode1().arrayRankTransform(new int[]{40, 10, 20, 30});
    }
}
