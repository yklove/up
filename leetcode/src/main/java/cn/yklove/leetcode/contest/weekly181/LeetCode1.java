package cn.yklove.leetcode.contest.weekly181;

import java.util.LinkedList;
import java.util.List;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    public int[] createTargetArray(int[] nums, int[] index) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            linkedList.add(index[i],nums[i]);
        }
        int[] ans = new int[nums.length];
        int count = 0;
        for (Integer integer : linkedList) {
            ans[count++] = integer;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
