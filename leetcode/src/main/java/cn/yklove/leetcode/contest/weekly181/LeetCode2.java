package cn.yklove.leetcode.contest.weekly181;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            Set<Integer> set = new HashSet<>();
            int ansTmp = 0;
            for (int i = 1; i <= Math.sqrt(num); i++) {
                int t = num / i;
                if (t * i == num) {
                    set.add(i);
                    set.add(t);
                    ansTmp += i;
                    ansTmp += t;
                }
                if (set.size() > 4) {
                    break;
                }
            }
            if (set.size() == 4) {
                ans += ansTmp;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
