package cn.yklove.leetcode.contest.weekly193;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qinggeng
 */
public class LeetCode4_2 {

    class TreeAncestor {

        int[] parent;

        public TreeAncestor(int n, int[] parent) {
            this.parent = parent;
        }

        public int getKthAncestor(int node, int k) {
            for (int i = 0; i < k; i++) {
                if (node < 0) {
                    return -1;
                }
                node = parent[node];
            }
            return node;
        }
    }



    public static void main(String[] args) {
        System.out.println(0xA<<2);
    }
}
