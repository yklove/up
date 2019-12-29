package cn.yklove.leetcode.contest.biweekly16;

/**
 * @author qinggeng
 * @date 2019/12/28
 */
public class LeetCode3 {

    public int deepestLeavesSum(TreeNode root) {
        return fun(root).val;
    }

    public Info fun(TreeNode node) {
        if (node == null) {
            Info info = new Info();
            info.count = 0;
            info.val = 0;
            return info;
        }
        if (node.left == null && node.right == null) {
            Info info = new Info();
            info.count = 1;
            info.val = node.val;
            return info;
        }
        Info left = fun(node.left);
        Info right = fun(node.right);
        if (left.count > right.count) {
            Info info = new Info();
            info.count = left.count + 1;
            info.val = left.val;
            return info;
        } else if (left.count == right.count) {
            Info info = new Info();
            info.count = left.count + 1;
            info.val = left.val + right.val;
            return info;
        } else {
            Info info = new Info();
            info.count = right.count + 1;
            info.val = right.val;
            return info;
        }
    }

    public class Info {
        int val;
        int count;
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
