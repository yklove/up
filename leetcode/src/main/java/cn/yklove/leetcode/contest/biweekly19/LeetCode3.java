package cn.yklove.leetcode.contest.biweekly19;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    public double angleClock(int hour, int minutes) {
        double v = minutes * 6 - (hour * 30 + minutes * 0.5);
        if (v < 0) {
            v += 360;
        }
        if (v > 180) {
            v = 360 - v;
        }
        return v;
    }

    public static void main(String[] args) {
        LeetCode3 leetCode3 = new LeetCode3();
        System.out.println(leetCode3.angleClock(12, 30));
        System.out.println(leetCode3.angleClock(3, 30));
        System.out.println(leetCode3.angleClock(3, 15));
        System.out.println(leetCode3.angleClock(4, 50));
        System.out.println(leetCode3.angleClock(12, 0));
    }
}
