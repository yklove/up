package cn.yklove.leetcode.contest.weekly175;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qinggeng
 */
public class LeetCode1 {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int icount = 0;
        int jcount = 0;
        for (int i : arr) {
            if (i == 0) {
                icount++;
            }
            if (i == 1) {
                jcount++;
            }
            set.add(i);
        }
        for (int i : arr) {
            if (set.contains(i * 2)) {
                if (i == 0) {
                    if (icount == 1) {
                        continue;
                    }
                }
                if (i == 1) {
                    if (jcount == 1) {
                        continue;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode1 leetCode1 = new LeetCode1();
        System.out.println(leetCode1.checkIfExist(new int[]{-20,8,-6,-14,0,-19,14,4}));
        System.out.println(leetCode1.checkIfExist(new int[]{-2, 0, 10, -19, 4, 6, -8}));
        System.out.println(leetCode1.checkIfExist(new int[]{10, 2, 5, 3}));
        System.out.println(leetCode1.checkIfExist(new int[]{7, 1, 14, 11}));
        System.out.println(leetCode1.checkIfExist(new int[]{3, 1, 7, 11}));
    }
}
