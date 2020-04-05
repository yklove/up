package cn.yklove.leetcode.contest.weekly183;

import java.math.BigInteger;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    public int numSteps(String s) {
        BigInteger bigInteger = new BigInteger(s, 2);
        BigInteger one = new BigInteger("1");
        BigInteger two = new BigInteger("2");
        BigInteger zero = new BigInteger("0");
        int count = 0;
        while (!bigInteger.equals(one)) {
            count++;
            if (bigInteger.mod(two).equals(zero)) {
                bigInteger = bigInteger.divide(two);
            } else {
                bigInteger = bigInteger.add(one);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode2 leetCode2 = new LeetCode2();
        System.out.println(leetCode2.numSteps("1111011110000011100000110001011011110010111001010111110001"));
        System.out.println(leetCode2.numSteps("1101"));
        System.out.println(leetCode2.numSteps("10"));
        System.out.println(leetCode2.numSteps("1"));
    }
}
