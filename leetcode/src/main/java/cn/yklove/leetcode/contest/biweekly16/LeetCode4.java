package cn.yklove.leetcode.contest.biweekly16;

import java.util.Arrays;
import java.util.List;

/**
 * @author qinggeng
 * @date 2019/12/28
 */
public class LeetCode4 {

    public int[] pathsWithMaxScore(List<String> board) {
        int[] ansx = new int[2];
        Info[][] ans = new Info[board.size()][board.size()];
        for (int i = board.size() - 1; i >= 0; i--) {
            String s = board.get(i);
            for (int j = board.size() - 1; j >= 0; j--) {
                if (s.charAt(j) == 'S') {
                    ans[i][j] = new Info(1, 0);
                    continue;
                }
                if (s.charAt(j) == 'X') {
                    ans[i][j] = new Info(0, 0);
                    continue;
                }
                Info right = get(ans, i, j + 1, board.size() - 1);
                Info down = get(ans, i + 1, j, board.size() - 1);
                Info downRight = get(ans, i + 1, j + 1, board.size() - 1);
                int maxVal = getMax(right, down, downRight);
                int count = 0;
                if (right.val == maxVal) {
                    count = (count + right.count) % 1000000007;
//                    ansx[1] = (ansx[1] + right.count) % 1000000007;
                }
                if (down.val == maxVal) {
                    count = (count + down.count) % 1000000007;
//                    ansx[1] = (ansx[1] + down.count) % 1000000007;
                }
                if (downRight.val == maxVal) {
                    count = (count + downRight.count) % 1000000007;
//                    ansx[1] = (ansx[1] + downRight.count) % 1000000007;
                }
                if (count == 0) {
                    ans[i][j] = new Info(0, 0);
                    continue;
                }
                if (s.charAt(j) != 'E') {
                    ans[i][j] = new Info(count, maxVal + (s.charAt(j) - '0'));
                } else {
                    ansx[0] = maxVal;
                    ansx[1] = count;
                }
            }
        }
        return ansx;
    }

    private int getMax(Info right, Info down, Info downRight) {
        return Math.max(Math.max(right.val, down.val), downRight.val);
    }

    private Info get(Info[][] ans, int i, int j, int max) {
        if (i < 0 || j < 0 || i > max || j > max) {
            return new Info(0, 0);
        }
        return ans[i][j];
    }

    class Info {
        int count;
        int val;

        public Info(int count, int val) {
            this.count = count;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int[] e23s = new LeetCode4().pathsWithMaxScore(Arrays.asList("E23","2X2","12S"));
        System.out.println(e23s[0] + " " + e23s[1]);
    }
}
