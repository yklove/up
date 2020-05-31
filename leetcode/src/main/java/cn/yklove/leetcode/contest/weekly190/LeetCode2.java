package cn.yklove.leetcode.contest.weekly190;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    public int maxVowels(String s, int k) {
        char[] chars = s.toCharArray();
        int[] tmp = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u') {
                tmp[i] = 1;
            }
        }
        int ans = -1;
        int count = 0;
        for (int i = 0; i < tmp.length; i++) {
            count += tmp[i];
            if(i == k-1){
                ans = count;
            }
            if (i >= k) {
                count -= tmp[i - k];
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

//        System.out.println(new LeetCode2().maxVowels("weallloveyou", 7));
        Scanner in = new Scanner(System.in);
        System.out.println(new LeetCode2().maxVowels(in.nextLine(), 3945));
    }
}
