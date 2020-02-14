package cn.yklove.alibaba;

/**
 * @author qinggeng
 */
public class Alibaba044 {

    public int solution(int n, int[] nums) {
        int maxIndex = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != maxIndex) {
                ans += ((nums[maxIndex] + nums[i]) / 2);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Alibaba044 alibaba044 = new Alibaba044();
        System.out.println(alibaba044.solution(5, new int[]{2, 4, 6, 8, 10}));
    }
}
