package cn.yklove.leetcode;

/**
 * @author qinggeng
 */
public class LeetCode1295 {

    public static void main(String[] args) {
        System.out.println(new LeetCode1295().findNumbers(new int[]{12, 345, 2, 6, 7896}));
    }

    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if ((num + "").length() % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
