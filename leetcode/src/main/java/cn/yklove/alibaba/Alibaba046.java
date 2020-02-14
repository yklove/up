package cn.yklove.alibaba;

import java.util.*;

/**
 * @author qinggeng
 */
public class Alibaba046 {

    public long solution(int n, long[] nums) {
        Map<Long, Long> map = new HashMap<>();
        for (long num : nums) {
            map.put(num, 0L);
        }
        for (long num : nums) {
            map.put(num, map.get(num) + 1);
        }
        List<Long> list = new ArrayList<>();
        for (Map.Entry<Long, Long> longLongEntry : map.entrySet()) {
            if (longLongEntry.getValue() >= 2) {
                list.add(longLongEntry.getKey());
            }
        }
        Collections.sort(list);
        if (list.size() == 0) {
            return 0;
        }
        if (list.size() == 1 && list.get(0) < 4) {
            return 0;
        }
        if (map.get(list.get(list.size() - 1)) >= 4) {
            return list.get(list.size() - 1) * list.get(list.size() - 1);
        } else {
            if (list.size() < 2) {
                return 0;
            }
            return list.get(list.size() - 1) * list.get(list.size() - 2);
        }
    }

    public static void main(String[] args) {
        Alibaba046 alibaba046 = new Alibaba046();
        System.out.println(alibaba046.solution(6, new long[]{1, 1, 2, 2, 3, 3}));
        System.out.println(alibaba046.solution(4, new long[]{1, 2, 3, 4}));
    }
}
