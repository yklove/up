package cn.yklove.leetcode.contest.weekly168;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if ((num + "").length() % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
