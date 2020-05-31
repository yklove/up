package cn.yklove.leetcode.contest.weekly188;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    static class Solution {
        public List<String> buildArray(int[] target, int n) {
            int current = 1;
            int i = 0;
            List<String> ans = new ArrayList<>();
            while (i < target.length) {
                ans.add("Push");
                if (target[i] != current++) {
                    ans.add("Pop");
                } else {
                    i++;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.buildArray(new int[]{1,3},3));
        System.out.println(solution.buildArray(new int[]{1,2,3},3));
        System.out.println(solution.buildArray(new int[]{1,2},4));
        System.out.println(solution.buildArray(new int[]{2,3,4},4));
    }
}
