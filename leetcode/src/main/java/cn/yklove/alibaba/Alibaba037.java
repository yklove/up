package cn.yklove.alibaba;

import java.util.stream.IntStream;

/**
 * @author qinggeng
 */
public class Alibaba037 {

    public int solution(int n, int[] a) {
        double max = 0.0;
        int maxInt = -1;
        for (int i = 0; i < a.length; i++) {
            double x = a[i];
            int j = i + 1;
            while (j < n && a[j] >= x) {
                x = (x + (double) a[j]) / 2.0;
                j++;
            }
            if (x > max) {
                maxInt = j - i;
                max = x;
            } else if (x == max) {
                maxInt = Math.max(j - i, maxInt);
            }
        }
        return maxInt;
    }

    public int solution2(int n, int[] a) {
        int max = IntStream.of(a).max().getAsInt();
        int count = 0;
        int maxAns = -1;
        for (int i : a) {
            if (i == max) {
                count++;
            } else {
                maxAns = Math.max(count, maxAns);
                count = 0;
            }
        }
        maxAns = Math.max(count, maxAns);
        return maxAns;
    }

    public static void main(String[] args) {
        Alibaba037 alibaba037 = new Alibaba037();
        System.out.println(alibaba037.solution2(6, new int[]{1, 2, 3, 3, 2, 1}));
        System.out.println(alibaba037.solution2(6, new int[]{1, 3, 3, 3, 2, 1}));
        System.out.println(alibaba037.solution2(6, new int[]{1, 3, 1, 3, 2, 1}));
    }
}
