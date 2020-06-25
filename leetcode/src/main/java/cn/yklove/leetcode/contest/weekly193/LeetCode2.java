package cn.yklove.leetcode.contest.weekly193;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Info> map = new HashMap<>();
        for (int i : arr) {
            if (!map.containsKey(i)) {
                map.put(i, new Info(i, 0));
            }
            Info info = map.get(i);
            info.count++;
        }
        ArrayList<Info> list = new ArrayList<>(map.values());
        list.sort(Comparator.comparingInt(o -> o.count));
        int count = 0;
        for (Info info : list) {
            if (k < info.count) {
                break;
            }
            k -= info.count;
            count++;
        }
        return list.size() - count;
    }

    class Info {
        int value;
        int count;

        public Info(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode2().findLeastNumOfUniqueInts(new int[]{4, 3, 1, 1, 3, 3, 2}, 3));
        System.out.println(new LeetCode2().findLeastNumOfUniqueInts(new int[]{5, 5, 4}, 1));
    }
}
