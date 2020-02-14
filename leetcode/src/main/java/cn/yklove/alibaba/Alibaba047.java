package cn.yklove.alibaba;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qinggeng
 */
public class Alibaba047 {
    public int solution(int n, int[] nums1, int[] nums2) {
        int sum = 0;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map1.put(nums1[i], i);
            map2.put(nums2[i], i);
        }
        for (int i : nums1) {
            for (int j = map1.get(i) + 1; j < nums1.length; j++) {
                if (map2.get(i) - map2.get(nums1[j]) > 0) {
                    sum++;
                    break;
                }
            }
        }
        return sum;
    }

    public int solution2(int n, int[] nums1, int[] nums2) {
        int[] x = new int[100001];
        int[] y = new int[100001];
        for (int i = 0; i < nums1.length; i++) {
            x[nums1[i]] = i;
            y[nums2[i]] = i;
        }
        int sum = 0;
        for (int i : nums1) {
            for (int j = x[i] + 1; j < nums1.length; j++) {
                if (y[i] - y[nums1[j]] > 0) {
                    sum++;
                    break;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Alibaba047 alibaba047 = new Alibaba047();
        System.out.println(alibaba047.solution(4, new int[]{1, 2, 3, 4}, new int[]{4, 3, 1, 2}));
        System.out.println(alibaba047.solution2(4, new int[]{1, 2, 3, 4}, new int[]{4, 3, 1, 2}));
        System.out.println(alibaba047.solution(5, new int[]{4, 2, 1, 3, 5}, new int[]{2, 4, 1, 5, 3}));
        System.out.println(alibaba047.solution2(5, new int[]{4, 2, 1, 3, 5}, new int[]{2, 4, 1, 5, 3}));
    }
}
