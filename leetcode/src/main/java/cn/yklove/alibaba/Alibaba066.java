package cn.yklove.alibaba;

/**
 * @author qinggeng
 */
public class Alibaba066 {

    public String solution(int value, int[] a) {
        StringBuilder stringBuilder = new StringBuilder();
        while (value > 0) {
            for (int i = a.length - 1; i >= 0; i--) {
                if (value >= a[i]) {
                    stringBuilder.append(i + 1);
                    value -= a[i];
                }
            }
        }
        if (stringBuilder.length() == 0) {
            return "-1";
        } else {
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        Alibaba066 alibaba066 = new Alibaba066();
//        System.out.println(alibaba066.solution(2, new int[]{9, 11, 1, 12, 5, 8, 9, 10, 6}));
//        System.out.println(alibaba066.solution(5, new int[]{2, 3}));
        System.out.println(alibaba066.solution(4, new int[]{2, 3}));
    }
}
