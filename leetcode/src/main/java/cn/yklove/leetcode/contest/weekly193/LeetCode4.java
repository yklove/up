package cn.yklove.leetcode.contest.weekly193;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qinggeng
 */
public class LeetCode4 {

    class TreeAncestor {

        class TreeNode {
            int value;
            TreeNode parent;

            public TreeNode(int value, TreeNode parent) {
                this.value = value;
                this.parent = parent;
            }
        }

        Map<Integer, TreeNode> map;

        public TreeAncestor(int n, int[] parent) {
            map = new HashMap<>(n * 2);
            for (int i = 0; i < n; i++) {
                map.put(i, new TreeNode(i, null));
            }
            for (int i = 0; i < parent.length; i++) {
                map.get(i).parent = map.get(parent[i]);
            }
        }

        public int getKthAncestor(int node, int k) {
            TreeNode treeNode = map.get(node);
            if (k == 0) {
                if (treeNode == null) {
                    return -1;
                }
                return treeNode.parent.value;
            }
            if (k == 1) {
                if (treeNode.parent == null) {
                    return -1;
                }
                return treeNode.parent.value;
            }
            for (int i = 0; i < k; i++) {
                treeNode = treeNode.parent;
            }
            return treeNode.value;
        }
    }

    public static void main(String[] args) {

    }
}
