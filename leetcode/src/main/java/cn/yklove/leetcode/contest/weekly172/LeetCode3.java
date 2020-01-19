package cn.yklove.leetcode.contest.weekly172;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        remove(null, root, target, 0);
        if (root.val == target && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }

    private void remove(TreeNode parent, TreeNode node, int target, int val) {
        if (node.left != null) {
            remove(node, node.left, target, 0);
        }
        if (node.right != null) {
            remove(node, node.right, target, 1);
        }
        if (node.val == target && node.left == null && node.right == null) {
            if(parent == null){
                return;
            }
            if (val == 0) {
                parent.left = null;
            } else {
                parent.right = null;
            }
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
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(1);
        treeNode.left.left = new TreeNode(1);
        new LeetCode3().removeLeafNodes(treeNode,1);
    }
}
