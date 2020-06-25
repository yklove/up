package cn.yklove.leetcode.contest.weekly192;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    static class BrowserHistory {

        private String[] list = new String[5001];
        private int current = 0;
        private int max = 0;

        public BrowserHistory(String homepage) {
            list[current] = homepage;
            current++;
            max++;
        }

        public void visit(String url) {
            list[current] = url;
            current++;
            max = current;
        }

        public String back(int steps) {
            if (current > steps) {
                current = current - steps;
                return list[current - 1];
            } else {
                current = 1;
                return list[current - 1];
            }
        }

        public String forward(int steps) {
            if (max > steps + current) {
                current = current + steps;
                return list[current - 1];
            } else {
                current = max;
                return list[current - 1];
            }
        }
    }

    /**
     * Your BrowserHistory object will be instantiated and called as such:
     * BrowserHistory obj = new BrowserHistory(homepage);
     * obj.visit(url);
     * String param_2 = obj.back(steps);
     * String param_3 = obj.forward(steps);
     */

    public static void main(String[] args) {
        BrowserHistory obj = new BrowserHistory("leetcode.com");
        obj.visit("google.com");
        obj.visit("facebook.com");
        obj.visit("youtube.com");
        System.out.println("null");
        System.out.println("null");
        System.out.println("null");
        System.out.println(obj.back(1));
        System.out.println(obj.back(1));
        System.out.println(obj.forward(1));
        obj.visit("linkedin.com");
        System.out.println("null");
        System.out.println(obj.forward(2));
        System.out.println(obj.back(2));
        System.out.println(obj.back(7));
    }
}
