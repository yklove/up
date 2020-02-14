package cn.yklove.alibaba;

import java.util.stream.IntStream;

/**
 * @author qinggeng
 */
public class Alibaba039 {

    public int solution(String s1, String s2) {
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        while (i >= 0 && j >= 0 && s1.charAt(i) == s2.charAt(j)) {
            i--;
            j--;
        }
        return i+1 + j+1;
    }

    public static void main(String[] args) {
        Alibaba039 alibaba039 = new Alibaba039();
        System.out.println(alibaba039.solution("dadc", "dddc"));
        System.out.println(alibaba039.solution("ddc", "dddc"));
        System.out.println(alibaba039.solution("a", "a"));
        System.out.println(alibaba039.solution("aa", "a"));
    }
}
