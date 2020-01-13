package cn.yklove.leetcode.contest.weekly171;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    public int minFlips(int a, int b, int c) {
        String a2 = String.format("%32s", Integer.toBinaryString(a)).replace(' ','0');
        String b2 = String.format("%32s", Integer.toBinaryString(b)).replace(' ','0');
        String c2 = String.format("%32s", Integer.toBinaryString(c)).replace(' ','0');
        int sum = 0;
        for (int i = 0; i < c2.length(); i++) {
            if (c2.charAt(i) == '0') {
                if (a2.charAt(i) == '1') {
                    sum++;
                }
                if (b2.charAt(i) == '1') {
                    sum++;
                }
            } else if (c2.charAt(i) == '1') {
                if (a2.charAt(i) != '1' && b2.charAt(i) != '1') {
                    sum++;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode2().minFlips(2, 6, 5));
        System.out.println(new LeetCode2().minFlips(4,2,7));
        System.out.println(new LeetCode2().minFlips(1,2,3));
        System.out.println(new LeetCode2().minFlips(3040,7257,4934));
    }
}
