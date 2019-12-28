package cn.yklove.leetcode;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author qinggeng
 * @date 2019-12-27
 */
public class LeetCode006 {

    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        char[][] z = new char[numRows][s.length()];
        boolean direction = false;
        int count = 0;
        int x = 0;
        int y = 0;
        for (char c : s.toCharArray()) {
            z[x][y] = c;
            if (!direction) {
                x++;
            } else {
                x--;
                y++;
            }
            count++;
            // 转换方向
            if (count == numRows - 1) {
                count = 0;
                direction = !direction;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char[] chars : z) {
            for (char aChar : chars) {
                if (aChar != '\u0000') {
                    stringBuilder.append(aChar);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode006().convert("LEETCODEISHIRING", 3));
        System.out.println(new LeetCode006().convert("PAYPALISHIRING", 4));
        System.out.println(new LeetCode006().convert("AB", 1));
    }

}
