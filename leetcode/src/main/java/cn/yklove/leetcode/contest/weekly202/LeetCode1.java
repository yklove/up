package cn.yklove.leetcode.contest.weekly202;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int i : arr) {
            if(i % 2 == 1){
                count++;
            }else{
                count = 0;
            }
            if(count == 3){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
