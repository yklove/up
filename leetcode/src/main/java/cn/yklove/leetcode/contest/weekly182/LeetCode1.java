package cn.yklove.leetcode.contest.weekly182;

import java.util.*;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    public int findLucky(int[] arr) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>((o1, o2) -> Integer.compare(o2,o1));
        for (int i : arr) {
            if (treeMap.containsKey(i)) {
                treeMap.put(i, treeMap.get(i) + 1);
            } else {
                treeMap.put(i, 1);
            }
        }
        Iterator iter = treeMap.entrySet().iterator();

        while(iter.hasNext()) {

            Map.Entry entry = (Map.Entry)iter.next();

            // 获取key

            int key = (int) entry.getKey();

            // 获取value

            int value = (int) entry.getValue();
            if(key == value){
                return key;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
