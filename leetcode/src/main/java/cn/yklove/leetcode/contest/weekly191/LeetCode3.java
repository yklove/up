package cn.yklove.leetcode.contest.weekly191;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    private int count = 0;
    public int minReorder(int n, int[][] connections) {
        count = 0;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }
        for (int[] connection : connections) {
            nodes[connection[0]].nexts.add(nodes[connection[1]]);
            nodes[connection[1]].parent.add(nodes[connection[0]]);
        }
        fun(nodes[0]);
        return count;
    }

    private void fun(Node node) {
        for (Node parent : node.parent) {
            parent.nexts.remove(node);
            fun(parent);
        }
        for (Node next : node.nexts) {
            count++;
            next.parent.remove(node);
            fun(next);
        }
    }

    private class Node {
        List<Node> nexts = new ArrayList<>();
        List<Node> parent = new ArrayList<>();
    }

    public static void main(String[] args) {
        LeetCode3 leetCode3 = new LeetCode3();
        System.out.println(leetCode3.minReorder(6,new int[][]{{0,1},{1,3},{2,3},{4,0},{4,5}}));
    }
}
