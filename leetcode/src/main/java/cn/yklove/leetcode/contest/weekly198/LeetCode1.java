package cn.yklove.leetcode.contest.weekly198;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        while (numBottles >= numExchange) {
            int i = numBottles / numExchange;
            ans += i;
            numBottles = i + numBottles % numExchange;
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = new LeetCode1().numWaterBottles(15, 4);
        System.out.println(i);
    }
}
