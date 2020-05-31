package cn.yklove.leetcode.contest.weekly188;

import java.util.*;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    public static void main(String[] args) {
        LeetCode3 leetCode3 = new LeetCode3();
        System.out.println(leetCode3.minTime(7, new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}, Arrays.asList(false, false, true, false, true, true, false)));
        System.out.println(leetCode3.minTime(7, new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}}, Arrays.asList(false,false,true,false,false,true,false)));
        System.out.println(leetCode3.minTime(7, new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}}, Arrays.asList(false,false,false,false,false,false,false)));
        System.out.println(leetCode3.minTime(4, new int[][]{{0, 1}, {1, 2}, {0, 3}}, Arrays.asList(true, true, true, true)));
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, Node> map = new HashMap<>(n * 2);
        for (int i = 0; i < n; i++) {
            Node node = new Node();
            node.hasApple = hasApple.get(i);
            node.val = i;
            map.put(i, node);
        }
        for (int[] edge : edges) {
            Node node = map.get(edge[0]);
            Node node1 = map.get(edge[1]);
            if (node.child == null) {
                node.child = new ArrayList<>();
            }
            node.child.add(node1);
        }
        return f(map.get(0));
    }

    private int f(Node node) {
        // 叶子节点
        if (node.child == null || node.child.size() == 0) {
            return 0;
        }
        int ans = 0;
        for (Node node1 : node.child) {
            int left = Objects.isNull(node1) ? 0 : f(node1);
            if (left != 0 || Objects.nonNull(node1) && node1.hasApple) {
                left += 2;
            }
            ans += left;
        }
        return ans;
    }

    static class Node {
        int val;
        boolean hasApple;
        List<Node> child;
    }

}
