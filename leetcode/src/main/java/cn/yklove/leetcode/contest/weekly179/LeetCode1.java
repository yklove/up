package cn.yklove.leetcode.contest.weekly179;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    public String generateTheString(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        if(n % 2 != 0){
            while (n-- > 0){
                stringBuilder.append('a');
            }
            return stringBuilder.toString();
        }else{
            while (n-- > 1){
                stringBuilder.append('a');
            }
            stringBuilder.append('b');
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        LeetCode1 leetCode1 = new LeetCode1();
        System.out.println(leetCode1.generateTheString(4));
        System.out.println(leetCode1.generateTheString(5));
    }

}
