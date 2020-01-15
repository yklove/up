package cn.yklove.leetcode;

/**
 * @author qinggeng
 */
public class LeetCode0647 {

    public int countSubstrings(String s) {
        StringBuilder tmpS = new StringBuilder("#");
        for (char c : s.toCharArray()) {
            tmpS.append(c).append("#");
        }
        String string = tmpS.toString();
        int[] p = new int[tmpS.length()];
        int center = 0;
        int right = 0;
        for (int i = 0; i < tmpS.length(); i++) {
            p[i] = 1;
            int start = i + 1;
            // 检查是否存在对称点
            if (center - (i - center) > 0) {
                // 存在对称点，移动start
                start = i + p[center - (i - center)];
            }
            if (start < right) {
                p[i] = p[center - (i - center)];
                continue;
            } else if (start > right) {
                start = right;
            }
            while (start < tmpS.length() && i - (start - i) >= 0) {
                if (string.charAt(start) == string.charAt(i - (start - i))) {
                    start++;
                } else {
                    break;
                }
            }
            p[i] = start - i;
            if (start > right) {
                center = i;
                right = start;
            }
        }
        int ans = 0;
        for (int value : p) {
            ans += (value / 2);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode0647().countSubstrings("dnncbwoneinoplypwgbwktmvkoimcooyiwirgbxlcttgteqthcvyoueyftiwgwwxvxvg"));
        System.out.println(new LeetCode0647().countSubstrings("a"));
        System.out.println(new LeetCode0647().countSubstrings("bccb"));
        System.out.println(new LeetCode0647().countSubstrings("abc"));
        System.out.println(new LeetCode0647().countSubstrings("aaa"));
    }

}
