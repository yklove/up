package cn.yklove.leetcode.contest.weekly174;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    public int[] kWeakestRows(int[][] mat, int k) {
        List<Info> list = new ArrayList<>(mat.length);
        for (int i = 0; i < mat.length; i++) {
            int[] ints = mat[i];
            int count = 0;
            for (int anInt : ints) {
                if (anInt == 1) {
                    count++;
                } else {
                    break;
                }
            }
            list.add(new Info(i, count));
        }
        list.sort(Comparator.comparingInt(o -> o.count));
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = list.get(i).index;
        }
        return ans;
    }

    static class Info {
        int index;
        int count;

        public Info(int index, int count) {
            this.index = index;
            this.count = count;
        }

    }

    public static void main(String[] args) {
        for (int i : new LeetCode1().kWeakestRows(new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        }, 3)) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
