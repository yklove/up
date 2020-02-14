package cn.yklove.alibaba;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qinggeng
 */
public class Alibaba045 {


    public int solution(int n, int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(-1, 0);
        for (int num : nums) {
            hashMap.put(num, 0);
            hashMap.put(num - 1, 0);
            hashMap.put(num + 1, 0);
        }
        for (int num : nums) {
            hashMap.put(num, hashMap.get(num) + 1);
            hashMap.put(num - 1, hashMap.get(num - 1) + 1);
            hashMap.put(num + 1, hashMap.get(num + 1) + 1);
        }
        int ans = -1;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : hashMap.entrySet()) {
            ans = Math.max(ans, integerIntegerEntry.getValue());
        }
        return ans;
    }

    public static void main(String[] args) {
        Alibaba045 alibaba045 = new Alibaba045();
        System.out.println(alibaba045.solution(8, new int[]{3, 2, 1, 5, 3, 4, 9, 5}));
    }
}
