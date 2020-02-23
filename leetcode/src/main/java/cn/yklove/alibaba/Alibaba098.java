package cn.yklove.alibaba;

/**
 * @author qinggeng
 */
public class Alibaba098 {
    public int solution(int n, int d, int[] a) {
        int count = 0;
        for (int i = 0; i < a.length-1; i++) {
            count += (d - a[i]);
        }
        return count;
    }
}
