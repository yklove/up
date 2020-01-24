package cn.yklove.leetcode;

/**
 * @author qinggeng
 */
public class LeetCode0042 {

    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            leftMax[i] = max;
            max = Math.max(max, height[i]);
        }
        max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            rightMax[i] = max;
            max = Math.max(max, height[i]);
        }
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            int tmp = Math.min(leftMax[i], rightMax[i]) - height[i];
            ans += Math.max(tmp, 0);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode0042().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
