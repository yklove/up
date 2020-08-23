package cn.yklove.leetcode.contest.weekly199;

import java.text.SimpleDateFormat;
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

    public int countPairs(TreeNode root, int distance) {
        parent = new HashMap<>();
        list = new ArrayList<>();
        xxx = new HashSet<>();
        dfs(root);
        int ans = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (lowestCommonAncestor(list.get(i), list.get(j)) <= distance) {
                    ans++;
                }
            }
        }
        return ans;
    }

    Map<TreeNode, TreeNode> parent;
    Set<TreeNode> visited;
    List<TreeNode> list;
    Set<TreeNode> xxx;

    public void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right, root);
            dfs(root.right);
        }
        if (root.left == null && root.right == null) {
            list.add(root);
        }
    }

    public int lowestCommonAncestor(TreeNode p, TreeNode q) {
        visited = new HashSet<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        int count = 0;
        while (p != null) {
            map.put(p, count);
            visited.add(p);
            p = parent.get(p);
            count++;
        }
        count = 0;
        while (q != null) {
            if (visited.contains(q)) {
                return count + map.get(q);
            }
            q = parent.get(q);
            count++;
        }
        return 0;
    }

    public static void main(String[] args) {



        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(1);
//        treeNode.left.right = new TreeNode(4);
        System.out.println(new LeetCode3().countPairs(treeNode, 2));
    }
}
