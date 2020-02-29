package cn.yklove.alibaba;

import java.util.Map;

/**
 * @author qinggeng
 */
public class Alibaba055 {

    private int[] map;

    private int getLength(int n) {
        if (map == null) {
            map = new int[46];
        }
        map[0] = 1;
        map[1] = 1;
        for (int i = 2; i < 46; i++) {
            map[i] = map[i - 1] + map[i - 2];
        }
        return map[n - 1];
    }

    public int solution(int n, int k) {
        if (n == 1) {
            if(k != 1){
                return -1;
            }
            return 0;
        }
        if (n == 2) {
            if(k != 1){
                return -1;
            }
            return 1;
        }
        if (n > 45) {
            return solution(n - 2, k);
        }
        int len1 = getLength(n - 2);
        if (k > len1) {
            return solution(n - 1, k - len1);
        } else {
            return solution(n - 2, k);
        }
    }

    public static void main(String[] args) {
        Alibaba055 alibaba055 = new Alibaba055();
//        System.out.println(alibaba055.solution(19, 98));
//        System.out.println(alibaba055.solution(1, 1));
//        System.out.println(alibaba055.solution(2, 1));
//        System.out.println(alibaba055.solution(3, 1));
//        System.out.println(alibaba055.solution(3, 2));
//        System.out.println(alibaba055.solution(4, 1));
//        System.out.println(alibaba055.solution(4, 2));
//        System.out.println(alibaba055.solution(4, 3));
//        System.out.println(alibaba055.solution(135, 6749));
        System.out.println(alibaba055.solution(19, 12899));
    }
}
