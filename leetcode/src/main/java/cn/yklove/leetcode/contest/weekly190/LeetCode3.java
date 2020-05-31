package cn.yklove.leetcode.contest.weekly190;

import java.util.*;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int pseudoPalindromicPaths(TreeNode root) {
        return process(root, new HashMap<>());
    }

    private int process(TreeNode root, Map<Integer, Integer> map) {
        if (map.containsKey(root.val)) {
            map.put(root.val, map.get(root.val) + 1);
        } else {
            map.put(root.val, 1);
        }
        int count = 0;
        if (root.left != null) {
            count += process(root.left, map);
        }
        if (root.right != null) {
            count += process(root.right, map);
        }
        if (root.left == null && root.right == null) {
            int tmp = 0;
            for (Integer integer : map.values()) {
                if (integer % 2 != 0) {
                    tmp++;
                }
            }
            if (tmp == 1 || tmp == 0) {
                map.put(root.val, map.get(root.val) - 1);
                return 1;
            } else {
                map.put(root.val, map.get(root.val) - 1);
                return 0;
            }
        }
        map.put(root.val, map.get(root.val) - 1);
        return count;
    }

    public static void main(String[] args) {
        LeetCode3 leetCode3 = new LeetCode3();
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(3);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(1);
        treeNode.right = new TreeNode(1);
        treeNode.right.right = new TreeNode(1);
        System.out.println(leetCode3.pseudoPalindromicPaths(treeNode));

    }
}
