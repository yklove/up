package cn.yklove.alibaba;

/**
 * @author qinggeng
 */
public class Alibaba051 {
    public String solution(int n, int[] nums) {
        if (nums.length == 1) {
            return "YES";
        }
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i - 1] <= nums[i]) {
                continue;
            }
            if (nums[i - 1] - 1 > nums[i]) {
                return "NO";
            }
            nums[i - 1]--;
        }
        return "YES";
    }

    public static void main(String[] args) {
        Alibaba051 alibaba051 = new Alibaba051();
        System.out.println(alibaba051.solution(5, new int[]{1, 1, 2, 1, 5}));
        System.out.println(alibaba051.solution(3, new int[]{5, 3, 1}));
        System.out.println(alibaba051.solution(3, new int[]{4, 3, 1}));
        System.out.println(alibaba051.solution(4, new int[]{1, 3, 2, 1}));
    }

}
