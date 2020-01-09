package cn.yklove.leetcode;

/**
 * @author qinggeng
 */
public class LeetCode0035 {


    public int searchInsert(int[] nums, int target) {
        return searchInsert(nums, target, 0, nums.length - 1);
    }

    public int searchInsert(int[] nums, int target, int start, int end) {
        int tmp = start + (end - start) / 2;
        if (nums[tmp] > target) {
            if(tmp - 1 >= start) {
                return searchInsert(nums, target, start, tmp - 1);
            }else{
                return tmp;
            }
        } else if (nums[tmp] < target) {
            if(tmp + 1 <= end) {
                return searchInsert(nums, target, tmp + 1, end);
            }else{
                return tmp + 1;
            }
        } else {
            return tmp;
        }
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode0035().searchInsert(new int[]{1,3,5,7},0));
        System.out.println(new LeetCode0035().searchInsert(new int[]{1,3,5,7},2));
        System.out.println(new LeetCode0035().searchInsert(new int[]{1,3,5,7},4));
        System.out.println(new LeetCode0035().searchInsert(new int[]{1,3,5,7},6));
        System.out.println(new LeetCode0035().searchInsert(new int[]{1,3,5,7},8));
        System.out.println(new LeetCode0035().searchInsert(new int[]{1,3,5},0));
        System.out.println(new LeetCode0035().searchInsert(new int[]{1,3,5},2));
        System.out.println(new LeetCode0035().searchInsert(new int[]{1,3,5},4));
        System.out.println(new LeetCode0035().searchInsert(new int[]{1,3,5},6));
    }

}
