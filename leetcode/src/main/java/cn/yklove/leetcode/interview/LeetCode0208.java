package cn.yklove.leetcode.interview;

/**
 * @author qinggeng
 */
public class LeetCode0208 {
    public ListNode detectCycle(ListNode head) {
        ListNode x = head;
        ListNode y = head;
        do {
            if (x == null || y == null || y.next == null) {
                return null;
            }
            x = x.next;
            y = y.next.next;
        } while (x != y);
        x = head;
        while (x != y) {
            x = x.next;
            y = y.next;
        }
        return x;
    }

    public static void main(String[] args) {
        LeetCode0208 leetCode0208 = new LeetCode0208();
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        System.out.println(leetCode0208.detectCycle(head).val);
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;
        System.out.println(leetCode0208.detectCycle(head).val);
        System.out.println(leetCode0208.detectCycle(new ListNode(1)));
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
