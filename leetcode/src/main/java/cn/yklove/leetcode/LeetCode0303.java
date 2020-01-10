package cn.yklove.leetcode;

class LeetCode0303 {

    private int[] nums;

    public LeetCode0303(int[] nums) {
        this.nums = nums;
        for (int k = 1; k < nums.length; k++) {
            nums[k] = nums[k] + nums[k - 1];
        }
    }
    
    public int sumRange(int i, int j) {
        if (i == 0) {
            return nums[j] - 0;
        } else {
            return nums[j] - nums[i - 1];
        }
    }
}