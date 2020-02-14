package cn.yklove.alibaba;

import java.util.TreeSet;

/**
 * @author qinggeng
 */
public class Alibaba049 {

    public int solution(int n, int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums) {
            treeSet.add(num);
        }
        Integer lower = treeSet.lower(50000);
        if (lower == null) {
            lower = 0;
        }
        Integer higher = treeSet.higher(50000);
        if (higher == null) {
            higher = 100000;
        }
        if(treeSet.contains(50000)){
            return 49999;
        }
        return Math.max(lower-1, 100000 - higher);
    }

    public static void main(String[] args) {
        Alibaba049 alibaba049 = new Alibaba049();
        System.out.println(alibaba049.solution(1, new int[]{49999}));
        System.out.println(alibaba049.solution(6, new int[]{2, 3, 50000, 99997, 99998, 99999}));
        System.out.println(alibaba049.solution(4, new int[]{350, 2000, 80000, 99999}));
        System.out.println(alibaba049.solution(4, new int[]{90000, 95000, 80000, 99999}));
        System.out.println(alibaba049.solution(4, new int[]{10000, 10000, 5000, 20000}));
    }
}
