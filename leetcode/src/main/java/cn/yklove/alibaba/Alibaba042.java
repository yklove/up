package cn.yklove.alibaba;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qinggeng
 */
public class Alibaba042 {

    public int solution(int n, int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        while (list.size() != 1) {
            int integer = list.stream().min(Integer::compareTo).get();
            boolean key = true;
            List<Integer> tmp = new ArrayList<>();
            for (int integer1 : list) {
                if (integer1 == integer && key) {
                    key = false;
                    tmp.add(integer1);
                    continue;
                }
                int i = integer1 % integer;
                if(i != 0) {
                    tmp.add(i);
                }
            }
            list = tmp;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        Alibaba042 alibaba042 = new Alibaba042();
        System.out.println(alibaba042.solution(4,new int[]{2,8,6,20}));
    }
}
