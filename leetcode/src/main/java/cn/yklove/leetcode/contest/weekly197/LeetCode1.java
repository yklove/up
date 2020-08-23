package cn.yklove.leetcode.contest.weekly197;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int sum = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            sum += factorial(integerIntegerEntry.getValue());
        }
        return sum;
    }

    private int factorial(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode1().numIdenticalPairs(new int[]{1,2,3,1,1,3}));
    }
}
