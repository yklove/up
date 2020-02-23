package cn.yklove.alibaba;

/**
 * @author qinggeng
 */
public class Alibaba053 {

    public int solution(int n, int[] nums) {
        int count = 0;
        int ans = 0;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i - 1] >= nums[i]) {
                count++;
            } else {
                ans = Math.max(ans, count);
                count = 0;
            }
        }
        ans = Math.max(ans, count);
        return ans;
    }

    public static void main(String[] args) {
        Alibaba053 alibaba053 = new Alibaba053();
        System.out.println(alibaba053.solution(5, new int[]{5, 4, 3, 2, 1}));
        System.out.println(alibaba053.solution(10, new int[]{6, 5, 4, 3, 2, 1, 5, 4, 3, 2, 1}));
    }

}
