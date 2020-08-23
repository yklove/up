package cn.yklove.leetcode.contest.weekly198;

import java.util.*;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    private int[] ans;

    Node[] nodes;

    boolean[] key;

    Map<Integer, List<Integer>> map;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        map = new HashMap<>();
        key = new boolean[n];
        for (int[] edge : edges) {
            if (map.containsKey(edge[0])) {
                map.get(edge[0]).add(edge[1]);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(edge[1]);
                map.put(edge[0], list);
            }
            if (map.containsKey(edge[1])) {
                map.get(edge[1]).add(edge[0]);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(edge[0]);
                map.put(edge[1], list);
            }
        }

        ans = new int[n];
        nodes = new Node[n];
        char[] chars = labels.toCharArray();
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
            nodes[i].label = chars[i];
            nodes[i].i = i;
        }
        function2(0);

        function(nodes[0]);
        return ans;
    }

    private void function2(int i) {
        key[i] = true;
        Node node = nodes[i];
        for (Integer integer : map.get(i)) {
            if (key[integer]) {
                continue;
            }
            node.list.add(nodes[integer]);
        }
        for (Integer integer : map.get(i)) {
            if (key[integer]) {
                continue;
            }
            function2(integer);
        }
    }

    private Info function(Node node) {
        if (node.list.size() == 0) {
            ans[node.i] = 1;
            Info info = new Info();
            info.map.put(node.label, 1);
            return info;
        }
        int count = 1;
        Info ansInfo = new Info();
        for (int i = 0; i < node.list.size(); i++) {
            Info info = function(node.list.get(i));
            for (Map.Entry<Character, Integer> characterIntegerEntry : info.map.entrySet()) {
                if (characterIntegerEntry.getKey() == node.label) {
                    count += characterIntegerEntry.getValue();
                }
                if (ansInfo.map.containsKey(characterIntegerEntry.getKey())) {
                    ansInfo.map.put(characterIntegerEntry.getKey(), ansInfo.map.get(characterIntegerEntry.getKey()) + characterIntegerEntry.getValue());
                } else {
                    ansInfo.map.put(characterIntegerEntry.getKey(), characterIntegerEntry.getValue());
                }
            }
        }
        ansInfo.map.put(node.label, count);
        ans[node.i] = count;
        return ansInfo;
    }

    private static class Info {
        Map<Character, Integer> map = new HashMap<>();
    }

    private static class Node {
        List<Node> list = new ArrayList<>();
        char label;
        int i;
    }

    public static void main(String[] args) {
        int[] aaabaaas = new LeetCode2().countSubTrees(4, new int[][]{{0, 2}, {0, 3}, {1, 2}}, "aeed");
        for (int aaabaaa : aaabaaas) {
            System.out.print(aaabaaa);
        }
    }
}
