package cn.yklove.leetcode;

/**
 * @author qinggeng
 */
public class LeetCode009 {

    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        try {
            return x == Integer.parseInt(new StringBuilder(String.valueOf(x)).reverse().toString());
        }catch (Exception e){
            return false;
        }
    }

}
