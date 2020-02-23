package cn.yklove.leetcode.interview;

/**
 * @author qinggeng
 */
public class LeetCode0206 {
    public boolean isPalindrome(ListNode head) {
        ListNode x = head;
        ListNode y = head;
        while (x != null && y != null && y.next != null) {
            x = x.next;
            y = y.next.next;
        }
        ListNode slow = x;
        ListNode pre = null;
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = temp;
        }
        while (pre != null && head != null) {
            if(pre.val != head.val){
                return false;
            }
            pre = pre.next;
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode0206 leetCode0206 = new LeetCode0206();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        System.out.println(leetCode0206.isPalindrome(head));
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
