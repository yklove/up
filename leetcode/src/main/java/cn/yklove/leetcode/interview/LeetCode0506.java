package cn.yklove.leetcode.interview;

/**
 * @author qinggeng
 */
public class LeetCode0506 {

    public int convertInteger(int A, int B) {
        int c = A ^ B;
        int count = 0;
        while (c != 0) {
            if ((c & 1) == 1) {
                count++;
            }
            c = c >>> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode0506 leetCode0506 = new LeetCode0506();
        System.out.println(leetCode0506.convertInteger(29, 15));
        System.out.println(leetCode0506.convertInteger(1, 2));
        System.out.println(leetCode0506.convertInteger(826966453, -729934991));
    }
}
