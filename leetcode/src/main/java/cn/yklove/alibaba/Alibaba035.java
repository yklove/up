package cn.yklove.alibaba;

import cn.yklove.leetcode.contest.biweekly16.LeetCode3;

/**
 * @author qinggeng
 */
public class Alibaba035 {

    public int solution(TreeNode root) {
        int pre = -1;
        if (root.right == null) {
            return root.left.val;
        }
        while (root.right != null) {
            pre = root.val;
            root = root.right;
        }
        return pre;
    }

    public static void main(String[] args) {
        Alibaba035 alibaba035 = new Alibaba035();
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);
        System.out.println(alibaba035.solution(treeNode));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
