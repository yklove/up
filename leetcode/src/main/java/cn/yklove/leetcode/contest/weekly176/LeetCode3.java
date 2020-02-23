package cn.yklove.leetcode.contest.weekly176;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    public int maxEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(o -> o[1]));
        Set<Integer> hashSet = new HashSet<>();
        for (int[] event : events) {
            for (int i = event[0]; i <= event[1]; i++) {
                if (hashSet.add(i)) {
                    break;
                }
            }
        }
        return hashSet.size();
    }

    public static void main(String[] args) {
        LeetCode3 leetCode3 = new LeetCode3();
        System.out.println(leetCode3.maxEvents(new int[][]{{1, 2}, {1, 2}, {3, 3}, {1, 5}, {1, 5}}));
        System.out.println(leetCode3.maxEvents(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 2}}));
    }
}
