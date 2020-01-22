package cn.yklove.leetcode.contest.weekly172;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author qinggeng
 */
public class LeetCode4 {


    public int minTaps(int n, int[] ranges) {
        List<Info> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new Info(i - ranges[i], i + ranges[i]));
        }
        list.sort(Comparator.comparingInt(o -> o.left));
        int current = 0;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        int count = 0;
        while (current < n) {
            boolean key = true;
            count++;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).left <= current) {
                    if (list.get(i).right > max) {
                        maxIndex = i;
                        max = list.get(i).right;
                        key = false;
                    }
                }
            }
            if (key) {
                return -1;
            }
            current = list.get(maxIndex).right;
        }
        return count;
    }

    static class Info {
        public Info(int left, int right) {
            this.left = left;
            this.right = right;
        }

        int left;
        int right;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode4().minTaps(5, new int[]{3, 4, 1, 1, 0, 0}));
        System.out.println(new LeetCode4().minTaps(1, new int[]{0, 0, 0, 0}));
        System.out.println(new LeetCode4().minTaps(7, new int[]{1, 2, 1, 0, 2, 1, 0, 1}));
        System.out.println(new LeetCode4().minTaps(8, new int[]{4,0,0,0,0,0,0,0,4}));
        System.out.println(new LeetCode4().minTaps(8, new int[]{4,0,0,0,4,0,0,0,4}));
    }
}
