package cn.yklove.leetcode.contest.weekly180;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    public static void main(String[] args) {
    }

    static class CustomStack {

        private int[] values;
        private int count;

        public CustomStack(int maxSize) {
            values = new int[maxSize];
        }

        public void push(int x) {
            if (count < values.length) {
                values[count++] = x;
            }
        }

        public int pop() {
            if (count > 0) {
                return values[--count];
            }
            return -1;
        }

        public void increment(int k, int val) {
            for (int i = 0; i < k && i < count; i++) {
                values[i] += val;
            }
        }
    }


}
