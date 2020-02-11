package cn.yklove.leetcode.contest.weekly174;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.putIfAbsent(i, 1);
            map.computeIfPresent(i, (key, value) -> value + 1);
        }

        return 0;
    }

}
