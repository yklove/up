package cn.yklove.leetcode;

/**
 * @author qinggeng
 */
public class LeetCode0011 {

    public int maxArea(int[] height) {

        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode0011().maxArea(new int[]{1,10,9,1,1,1,9,1}));
    }
}
