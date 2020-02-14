package cn.yklove.alibaba;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qinggeng
 */
public class Alibaba065 {

    public long solution(int k, String s) {
        char[] chars = s.toCharArray();
        int[] dp = new int[s.length()];
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                dp[count++] = i;
            }
        }
        long ans = 0;
        for (int i = 0; i < count-1; i++) {
            int counti = dp[i] - ((i - 1) >= 0 ? dp[i - 1] : 0);
            int countk = ((i + 2 < count) ? dp[i + 2] : (chars.length-1)) - dp[i+1];
            ans += (counti * countk + counti + countk + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Alibaba065 alibaba065 = new Alibaba065();
        System.out.println(alibaba065.solution(2, "01010"));
        System.out.println(alibaba065.solution(2, "0101010"));
    }
}
