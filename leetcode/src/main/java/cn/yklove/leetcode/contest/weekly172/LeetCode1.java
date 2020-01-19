package cn.yklove.leetcode.contest.weekly172;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    public int maximum69Number (int num) {
        String x = num + "";
        StringBuilder stringBuilder = new StringBuilder();
        boolean key = true;
        for (char c : x.toCharArray()) {
            if(key && c == '6'){
                stringBuilder.append('9');
                key = false;
            }else{
                stringBuilder.append(c);
            }
        }
        return Integer.parseInt(stringBuilder.toString());
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode1().maximum69Number(9669));;
    }
}
