package cn.yklove.leetcode.contest.biweekly18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    public int[][] diagonalSort(int[][] mat) {

        int i = mat.length - 1;
        int j = 0;
        while (true) {

            List<Integer> list = new ArrayList<>();
            for (int t = i, m = j; t < mat.length && m < mat[t].length; t++, m++) {
                list.add(mat[t][m]);
            }
            Collections.sort(list);
            for (int t = i, m = j; t < mat.length && m < mat[t].length; t++, m++) {
                mat[t][m] = list.get(0);
                list.remove(0);
            }
            i--;
            if(i < 0){
                i=0;
                j++;
            }
            if(j > mat[i].length){
                break;
            }
        }
        return mat;
    }


    public static void main(String[] args) {
        new LeetCode3().diagonalSort(new int[][]{
                {3,3,1,1},
                {2,2,1,2},
                {1,1,1,2},
        });
    }
}
