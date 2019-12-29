package cn.yklove.leetcode.contest.biweekly16;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    public int[] replaceElements(int[] arr) {
        int[] ans = new int[arr.length];
        ans[arr.length - 1] = -1;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(arr.length, Comparator.reverseOrder());
        for (int i = arr.length - 1; i > 0; i--) {
            priorityQueue.add(arr[i]);
            ans[i - 1] = priorityQueue.peek();
        }
        return ans;
    }

    public static void main(String[] args) {
        for (int i : new LeetCode1().replaceElements(new int[]{17, 18, 5, 4, 6, 1})) {
            System.out.print(i + " ");
        }
    }

}
