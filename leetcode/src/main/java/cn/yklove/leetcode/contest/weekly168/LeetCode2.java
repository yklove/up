package cn.yklove.leetcode.contest.weekly168;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    public boolean isPossibleDivide(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        while (map.size() != 0) {
            Map.Entry<Integer, Integer> start = map.firstEntry();
            map.remove(start.getKey());
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            for (int i = 1; i < k; i++) {
                if (!iterator.hasNext()) {
                    return false;
                }
                Map.Entry<Integer, Integer> tmp = iterator.next();
                if (tmp.getKey() != start.getKey() + i || tmp.getValue() < start.getValue()) {
                    return false;
                }
                if (tmp.getValue().equals(start.getValue())) {
                    iterator.remove();
                } else {
                    tmp.setValue(tmp.getValue() - start.getValue());
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode2 leetCode2 = new LeetCode2();
        System.out.println(leetCode2.isPossibleDivide(new int[]{1, 2, 3, 3, 4, 4, 5, 6}, 4));
        System.out.println(leetCode2.isPossibleDivide(new int[]{3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11}, 3));
        System.out.println(leetCode2.isPossibleDivide(new int[]{3, 3, 2, 2, 1, 1}, 3));
        System.out.println(leetCode2.isPossibleDivide(new int[]{1, 2, 3, 4}, 3));
    }
}
