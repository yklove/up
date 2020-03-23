package cn.yklove.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qinggeng
 */
public class LeetCode0225 {

    class MyStack {

        private List<Integer> list;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            list = new ArrayList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            list.add(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.remove(list.size() - 1);
        }

        /**
         * Get the top element.
         */
        public int top() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return list.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

}
