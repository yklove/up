package cn.yklove.leetcode;

/**
 * @author qinggeng
 */
public class LeetCode0547 {

    public static void main(String[] args) {
//        System.out.println(new LeetCode0547().findCircleNum(new int[][]{
//                {1, 1, 0}, {1, 1, 0}, {0, 0, 1}
//        }));
//        System.out.println(new LeetCode0547().findCircleNum(new int[][]{
//                {1, 1, 0}, {1, 1, 1}, {0, 1, 1}
//        }));
        System.out.println(new LeetCode0547().findCircleNum(new int[][]{
                {1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0},
                {1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1}}
        ));
    }

    private int[] t;

    public int findCircleNum(int[][] M) {
        t = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            t[i] = i;
        }
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                if (M[i][j] == 1) {
                    t[f(j)] = f(i);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < t.length; i++) {
            if (i == t[i]) {
                count++;
            }
        }
        return count;
    }

    private int f(int x) {
        if (x != t[x]) {
            int f = f(t[x]);
            t[x] = f;
            return f;
        } else {
            return x;
        }
    }

}
