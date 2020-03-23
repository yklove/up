package cn.yklove.leetcode.contest.weekly179;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    public int numTimesAllBlue(int[] light) {
        int m = 1, count = 0;
        for (int i = 0; i < light.length; i++) {
            m = Math.max(light[i], m);
            if (m == i + 1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode2 leetCode2 = new LeetCode2();
        System.out.println(leetCode2.numTimesAllBlue(new int[]{2, 1, 3, 5, 4}));
    }

}
