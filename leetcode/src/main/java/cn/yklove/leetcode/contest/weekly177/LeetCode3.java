package cn.yklove.leetcode.contest.weekly177;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    public int[] closestDivisors(int num) {
        int x = num + 1;
        int y = num + 2;
        int a1 = 1;
        int a2 = x;
        double sqrtX = Math.sqrt(x);
        for (int i = 2; i <= sqrtX; i++) {
            if (x % i == 0) {
                a1 = i;
                a2 = x / i;
            }
        }
        int b1 = 1;
        int b2 = y;
        double sqrtY = Math.sqrt(y);
        for (int i = 2; i <= sqrtY; i++) {
            if (y % i == 0) {
                b1 = i;
                b2 = y / i;
            }
        }
        if (Math.abs(a1 - a2) < Math.abs(b1 - b2)) {
            return new int[]{a1, a2};
        } else {
            return new int[]{b1, b2};
        }
    }

    public static void main(String[] args) {
        LeetCode3 leetCode3 = new LeetCode3();
        for (int i : leetCode3.closestDivisors(123)) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
