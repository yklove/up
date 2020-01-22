package cn.yklove.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author qinggeng
 */
public class LeetCode0047 {

    private List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(nums);
        backtrack(nums, track);
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            List<Integer> tmp = new ArrayList<>();
            for (Integer index : track) {
                tmp.add(nums[index]);
            }
            res.add(tmp);
            return;
        }
        int pre = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == pre) {
                continue;
            }
            if (track.contains(i)) {
                continue;
            }
            pre = num;
            track.add(i);
            backtrack(nums, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode0047().permuteUnique(new int[]{1, 1, 2}));
        System.out.println(new LeetCode0047().permuteUnique(new int[]{1, 2, 3}));
    }
}
