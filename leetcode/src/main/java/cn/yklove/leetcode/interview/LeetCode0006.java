package cn.yklove.leetcode.interview;

import cn.yklove.leetcode.LeetCode0060;

/**
 * @author qinggeng
 */
public class LeetCode0006 {

    public int[] reversePrint(ListNode head) {
        if(head == null){
            return new int[0];
        }
        ListNode current = head.next;
        ListNode pre = head;
        head.next = null;
        int count = 1;
        while (current != null) {
            count++;
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        int[] ans = new int[count];
        int count2 = 0;
        while (pre != null){
            ans[count2++] = pre.val;
            pre = pre.next;
        }
        return ans;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        LeetCode0006 leetCode0006 = new LeetCode0006();
        for (int i : leetCode0006.reversePrint(head)) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
