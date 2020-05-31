package cn.yklove.leetcode.contest.test;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    public int minTime(int[] time, int m) {

        int l = 0;
        int r = 0;
        for (int i = 0; i < time.length - 1; i++) {
            if (time[i] > l) {
                l = time[i];
            }
            r += time[i];
        }
        while (l <= r) {
            int mid = (l + r) / 2;
            int o = time[1];
            int xh = 1;
            for (int i = 2; i <= time.length - 1; i++) {
                if (time[i] + o > mid) {
                    xh++;
                    o = time[i];
                } else {
                    o += time[i];
                }
            }
            if (xh > m) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }


    public static void main(String[] args) {
        LeetCode2 leetCode2 = new LeetCode2();
        System.out.println(leetCode2.minTime(new int[]{1, 4, 3, 5, 0}, 2));
//        System.out.println(leetCode2.minTime(new int[]{999, 999, 999}, 4));
//        System.out.println(leetCode2.minTime(new int[]{1, 2, 3, 2, 5, 4}, 3));
    }
}
