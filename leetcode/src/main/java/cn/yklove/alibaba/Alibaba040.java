package cn.yklove.alibaba;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qinggeng
 */
public class Alibaba040 {

    public int solution(int n, int[] nums) {
        Map<Integer, Integer> c = new HashMap<>();
        for (int num : nums) {
            if (c.containsKey(num)) {
                c.put(num, c.get(num) + 1);
            } else {
                c.put(num, 1);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            boolean ok = false;
            for (int j = 0; j < 31; j++) {
                int x = (1 << j) - nums[i];
                if (c.containsKey(x) && (c.get(x) > 1 || (c.get(x) == 1 && x != nums[i])))
                    ok = true;
            }
            if (!ok)
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Alibaba040 alibaba040 = new Alibaba040();
        System.out.println(alibaba040.solution(3, new int[]{1, 2, 3}));
        System.out.println(alibaba040.solution(3, new int[]{1, 1, 2}));
    }

}
