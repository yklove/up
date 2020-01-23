package cn.yklove.leetcode;

/**
 * @author qinggeng
 */
public class LeetCode1281 {

    public int subtractProductAndSum(int n) {
        int x = 0;
        int y = 1;
        while (n != 0) {
            int tmp = n % 10;
            n = n / 10;
            x+=tmp;
            y*=tmp;
        }
        return y - x;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode1281().subtractProductAndSum(234));
        System.out.println(new LeetCode1281().subtractProductAndSum(4421));
    }

}
