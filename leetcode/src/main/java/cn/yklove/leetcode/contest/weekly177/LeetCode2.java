package cn.yklove.leetcode.contest.weekly177;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new Node(i));
        }
        for (int i = 0; i < n; i++) {
            Node node = map.get(i);
            if(leftChild[i] != -1){
                node.child.add(map.get(leftChild[i]));
                map.get(leftChild[i]).parent.add(node);
                if (map.get(leftChild[i]).parent.size() > 1) {
                    return false;
                }
            }
            if(rightChild[i] != -1){
                node.child.add(map.get(rightChild[i]));
                map.get(rightChild[i]).parent.add(node);
                if (map.get(rightChild[i]).parent.size() > 1) {
                    return false;
                }
            }
            if (node.child.size() > 2) {
                return false;
            }
        }
        int count = 0;
        for (Map.Entry<Integer, Node> integerNodeEntry : map.entrySet()) {
            if(integerNodeEntry.getValue().parent.size() == 0){
                count++;
            }
        }
        if(count == 1){
            return true;
        }
        return false;
    }

    static class Node {
        public Node(int index) {
            this.index = index;
        }

        int index;
        List<Node> parent = new ArrayList<>();
        List<Node> child = new ArrayList<>();
    }

    public static void main(String[] args) {
        LeetCode2 leetCode2 = new LeetCode2();
        System.out.println(leetCode2.validateBinaryTreeNodes(2,new int[]{1,0},new int[]{-1,-1}));
        System.out.println(leetCode2.validateBinaryTreeNodes(4,new int[]{1,-1,3,-1},new int[]{2,3,-1,-1}));
        System.out.println(leetCode2.validateBinaryTreeNodes(4,new int[]{1,-1,3,-1},new int[]{2,-1,-1,-1}));
    }
}
