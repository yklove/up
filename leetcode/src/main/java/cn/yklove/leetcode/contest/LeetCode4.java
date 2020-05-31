package cn.yklove.leetcode.contest;

/**
 * @author qinggeng
 */
public class LeetCode4 {

    public int minJump(int[] jump) {
        int count = 0;
        int i = 0;
        while (true) {
            count++;
            int j = i + jump[i];
            if (j >= jump.length) {
                return count;
            }
            int max = Integer.MIN_VALUE;
            int maxIndex = -1;
            for (int t = 0; t < i; t++) {
                if (jump[t] + t >= max) {
                    max = jump[t] + t;
                    maxIndex = t;
                }
            }
            if (jump[j] + j >= max) {
                maxIndex = j;
            }
            i = maxIndex;
        }
    }

    public static void main(String[] args) {
        LeetCode4 leetCode4 = new LeetCode4();
        System.out.println(leetCode4.minJump(new int[]{3,7,6,1,4,3,7,8,1,2,8,5,9,8,3,2,7,5,1,1}));
//        System.out.println(leetCode4.minJump(new int[]{2, 5, 1, 1, 1, 1}));
//        System.out.println(leetCode4.minJump(new int[]{2, 1, 1, 1, 1, 1}));
//        System.out.println(leetCode4.minJump(new int[]{5}));
    }
}
