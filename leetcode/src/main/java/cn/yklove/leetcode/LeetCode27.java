package cn.yklove.leetcode;

/**
 * @author qinggeng
 */
public class LeetCode27 {

    public int removeElement(int[] nums, int val) {
        if(null == nums || 0 == nums.length){
            return 0;
        }
        int x = 0;
        int y = x + 1;
        while (y != nums.length){
            if(nums[x] == val){
                nums[x] = nums[y];
                nums[y] = val;
                y++;
                if(nums[x] != val){
                    x++;
                }
            }else{
                x++;
            }
            if(x == y){
                y++;
            }
        }
        if(nums[nums.length - 1] != val){
            x++;
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode27().removeElement(new int[]{4,5},4));
        System.out.println(new LeetCode27().removeElement(new int[]{2},3));
        System.out.println(new LeetCode27().removeElement(new int[]{3,3},5));
        System.out.println(new LeetCode27().removeElement(new int[]{3,2,2,3},3));
        System.out.println(new LeetCode27().removeElement(new int[]{0,1,2,2,3,0,4,2},2));
        System.out.println(new LeetCode27().removeElement(new int[]{0},2));
        System.out.println(new LeetCode27().removeElement(new int[]{},2));
    }


}
