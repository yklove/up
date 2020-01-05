package cn.yklove.leetcode.contest.weekly170;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    public static void main(String[] args) {
        System.out.println(new LeetCode1().freqAlphabets("10#11#12"));
        System.out.println(new LeetCode1().freqAlphabets("1326#"));
        System.out.println(new LeetCode1().freqAlphabets("25#"));
        System.out.println(new LeetCode1().freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
    }

    public String freqAlphabets(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        s = s + "  ";
        for (int i = 0; i < s.length()-2; i++) {
            if (s.charAt(i + 2) != '#') {
                stringBuilder.append((char)('a' + (s.charAt(i) - '1')));
            } else {
                stringBuilder.append((char)('j'
                        + ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') - 10)
                ));
                i+=2;
            }
        }
        return stringBuilder.toString();
    }
}
