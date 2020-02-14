package cn.yklove.alibaba;

import java.util.Arrays;

/**
 * @author qinggeng
 */
public class Alibaba043 {
    public int solution(int a, int b, int c) {
        int[] nums = new int[]{a,b,c};
        Arrays.sort(nums);
        return nums[1] - nums[0] + nums[2] - nums[1];
    }

    public static void main(String[] args) {
        Alibaba043 alibaba043 = new Alibaba043();
        System.out.println(alibaba043.solution(2,5,8));
        System.out.println(alibaba043.solution(1,2,3));
    }
}
