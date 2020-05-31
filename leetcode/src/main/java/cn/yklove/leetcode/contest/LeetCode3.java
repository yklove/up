package cn.yklove.leetcode.contest;

import java.util.*;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int C = 0;
        int R = 0;
        int H = 0;
        int[] ans = new int[requirements.length];
        Map<Info, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < requirements.length; i++) {
            int[] requirement = requirements[i];
            Info info = new Info(requirement[0], requirement[1], requirement[2]);
            if (map.containsKey(info)) {
                map.get(info).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(info, list);
            }
        }
        Arrays.fill(ans, -1);
        Info infoTmp = new Info(0, 0, 0);
        if (map.containsKey(infoTmp)) {
            for (Integer integer : map.get(infoTmp)) {
                if (ans[integer] == -1) {
                    ans[integer] = 0;
                }
            }
        }
        for (int i = 0; i < increase.length; i++) {
            int[] ints = increase[i];
            C += ints[0];
            R += ints[1];
            H += ints[2];
            for (int j = 0; j <= C; j++) {
                for (int k = 0; k <= R; k++) {
                    for (int l = 0; l <= H; l++) {
                        Info info = new Info(j, k, l);
                        if (map.containsKey(info)) {
                            for (Integer integer : map.get(info)) {
                                if (ans[integer] == -1) {
                                    ans[integer] = i + 1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }

    static class Info {
        int c, r, h;

        public Info(int c, int r, int h) {
            this.c = c;
            this.r = r;
            this.h = h;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Info info = (Info) o;
            return c == info.c &&
                    r == info.r &&
                    h == info.h;
        }

        @Override
        public int hashCode() {
            return Objects.hash(c, r, h);
        }
    }


    public static void main(String[] args) {
        LeetCode3 leetCode3 = new LeetCode3();
        int[] triggerTime = leetCode3.getTriggerTime(new int[][]{
//                {2, 8, 4}, {2, 5, 0}, {10, 9, 8}
                {1, 1, 1}
        }, new int[][]{
//                {2, 11, 3}, {15, 10, 7}, {9, 17, 12}, {8, 1, 14}
                {0, 0, 0}
        });
        for (int i : triggerTime) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
