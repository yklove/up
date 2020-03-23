package cn.yklove.leetcode.contest.weekly180;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    public List<Integer> luckyNumbers(int[][] matrix) {
        List<PriorityQueue<Integer>> list = new ArrayList<>();
        for (int[] ints : matrix) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
            for (int anInt : ints) {
                priorityQueue.add(anInt);
            }
            list.add(priorityQueue);
        }
        List<PriorityQueue<Integer>> list2 = new ArrayList<>();
        for (int i = 0; i < matrix[0].length; i++) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
            for (int[] ints : matrix) {
                int temp = ints[i];
                priorityQueue.add(temp);
            }
            list2.add(priorityQueue);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int[] ints = matrix[i];
            for (int j = 0; j < ints.length; j++) {
                if (list.get(i).peek() == matrix[i][j] && list2.get(j).peek() == matrix[i][j]) {
                    ans.add(matrix[i][j]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1 leetCode1 = new LeetCode1();
        System.out.println(leetCode1.luckyNumbers(new int[][]{{3, 7, 8}, {9, 11, 13}, {15, 16, 17}}));
        System.out.println(leetCode1.luckyNumbers(new int[][]{{1,10,4,2},{9,3,8,7},{15,16,17,12}}));
    }

}
