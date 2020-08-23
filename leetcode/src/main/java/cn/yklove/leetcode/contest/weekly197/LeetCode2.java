package cn.yklove.leetcode.contest.weekly197;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    public int numSub(String s) {
        char[] chars = (s + "0").toCharArray();
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (char aChar : chars) {
            if (aChar == '1') {
                count++;
            } else {
                if (count > 0) {
                    if (map.containsKey(count)) {
                        map.put(count, map.get(count) + 1);
                    } else {
                        map.put(count, 1);
                    }
                }
                count = 0;
            }
        }
        long sum = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            sum += ((factorial(integerIntegerEntry.getKey()) * integerIntegerEntry.getValue()) % (1000000000 + 7));
            sum %= (1000000000 + 7);
        }
        return (int) sum;
    }

    private long factorial(int n) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
            sum %= (1000000000 + 7);

        }
        return sum;
    }


    public static void main(String[] args) {
//        System.out.println(new LeetCode2().numSub("0110111"));
        Scanner in = new Scanner(System.in);
        System.out.println(new LeetCode2().numSub(in.nextLine()));
    }
}
