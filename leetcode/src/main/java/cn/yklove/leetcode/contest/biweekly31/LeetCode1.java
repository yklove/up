package cn.yklove.leetcode.contest.biweekly31;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    public int countOdds(int low, int high) {
        if (low == high) {
            if (low % 2 == 0) {
                return 0;
            } else {
                return 1;
            }
        }
        int count = 0;
        if (low % 2 != 0) {
            count++;
        }
        if (high % 2 != 0) {
            count++;
        }
        int i = (high - low - 1);
        int t = i / 2;
        if (count == 0) {
            t += 1;
        }
        count += t;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode1().countOdds(3, 7));
        System.out.println(new LeetCode1().countOdds(8, 10));
        System.out.println(new LeetCode1().countOdds(8, 12));
    }

}
