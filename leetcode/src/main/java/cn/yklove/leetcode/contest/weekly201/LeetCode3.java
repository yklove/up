package cn.yklove.leetcode.contest.weekly201;

import java.util.HashMap;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    public static void main(String[] args) {
        System.out.println(new LeetCode3().maxNonOverlapping(new int[]{-5, 5, -4, 5, 4}, 5));
//        System.out.println(new LeetCode3().maxNonOverlapping(new int[]{1, 1, 1, 1, 1}, 2));
//        System.out.println(new LeetCode3().maxNonOverlapping(new int[]{-1, 3, 5, 1, 4, 2, -9}, 6));
//        System.out.println(new LeetCode3().maxNonOverlapping(new int[]{-2, 6, 6, 3, 5, 4, 1, 2, 8}, 10));
//        System.out.println(new LeetCode3().maxNonOverlapping(new int[]{0, 0, 0}, 0));
    }

    public int maxNonOverlapping(int[] nums, int target) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        HashMap<Integer, Integer> mp2 = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            mp2.put(nums[i],i);
        }
        mp.put(0, 1);
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - target)) {
                if (mp2.get(pre - target) > index) {
                    count += 1;
                    index = i;
                }
            } else if (nums[i] == target) {
                count += 1;
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k))
                count += mp.get(pre - k);
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
