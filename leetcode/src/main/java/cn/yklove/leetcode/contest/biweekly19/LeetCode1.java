package cn.yklove.leetcode.contest.biweekly19;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    public int numberOfSteps(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode1().numberOfSteps(10000000));
    }
}
