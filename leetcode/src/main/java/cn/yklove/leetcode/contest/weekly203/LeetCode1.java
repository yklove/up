package cn.yklove.leetcode.contest.weekly203;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    public List<Integer> mostVisited(int n, int[] rounds) {
        Map<Integer, Integer> map = new HashMap<>();
        int start = rounds[0];
        map.put(start, 1);
        for (int i = 1; i < rounds.length; i++) {
            int end = rounds[i];
            while (start != end) {
                start++;
                start = start % (n + 1);
                if (start == 0) {
                    start++;
                }
                map.put(start, map.getOrDefault(start, 0) + 1);
            }
        }
        List<Integer> collect = map.keySet().stream().sorted((o1, o2) -> map.get(o2).compareTo(map.get(o1))).collect(Collectors.toList());
        List<Integer> ans = new ArrayList<>();
        for (Integer integer : collect) {
            if (map.get(integer).equals(map.get(collect.get(0)))) {
                ans.add(integer);
            } else {
                break;
            }
        }
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode1().mostVisited(4, new int[]{1, 3, 1, 2}));
        System.out.println(new LeetCode1().mostVisited(2, new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2}));
        System.out.println(new LeetCode1().mostVisited(7, new int[]{1, 3, 5, 7}));
        System.out.println(new LeetCode1().mostVisited(17, new int[]{16, 8}));
        System.out.println(new LeetCode1().mostVisited(3, new int[]{3, 2, 1, 2, 1, 3, 2, 1, 2, 1, 3, 2, 3, 1}));
    }
}
