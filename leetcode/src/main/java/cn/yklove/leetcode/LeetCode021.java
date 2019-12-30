package cn.yklove.leetcode;

/**
 * @author qinggeng
 */
public class LeetCode021 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(-1);
        ListNode currentNode = root;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                currentNode.next = l1;
                l1 = l1.next;
            } else {
                l2 = l2.next;
                currentNode.next = l2;
            }
            currentNode = currentNode.next;
        }
        while (l1 != null) {
            currentNode.next = l1;
            l1 = l1.next;
            currentNode = currentNode.next;
        }
        while (l2 != null) {
            currentNode.next = l2;
            l2 = l2.next;
            currentNode = currentNode.next;
        }
        return root.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
