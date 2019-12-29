package cn.yklove.leetcode.contest.weekly16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    PriorityQueue<Integer> ans = new PriorityQueue<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        fun(root1);
        fun(root2);
        List<Integer> list = new ArrayList<>();
        while (!ans.isEmpty()) {
            list.add(ans.poll());
        }
        return list;
    }

    private void fun(TreeNode root) {
        if (root != null) {
            ans.add(root.val);
            fun(root.left);
            fun(root.right);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }
}
