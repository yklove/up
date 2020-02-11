package cn.yklove.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 通过递归的方式从某些数中选出制定的数放到最前面，重复这个过程
 *
 * @author qinggeng
 */
public class LeetCode0060 {

    private List<Integer> ans;

    public String getPermutation(int n, int k) {
        ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        f(list, k);
        return ans.stream().map(String::valueOf).collect(Collectors.joining(""));
    }

    private void f(List<Integer> list, int k) {
        if (k == 0 || list.size() == 0) {
            ans.addAll(list);
            return;
        }
        int length = nxx(list.size() - 1);
        int tmp = (k - 1) / length;
        ans.add(list.get(tmp));
        list.remove(tmp);
        f(list, k - tmp * length);
    }

    private int nxx(int n) {
        int tmp = 1;
        for (int i = 1; i <= n; i++) {
            tmp *= i;
        }
        return tmp;
    }

    public static void main(String[] args) {
        LeetCode0060 leetCode0060 = new LeetCode0060();
        System.out.println(leetCode0060.getPermutation(2, 1));
        System.out.println(leetCode0060.getPermutation(2, 2));
        System.out.println(leetCode0060.getPermutation(3, 1));
        System.out.println(leetCode0060.getPermutation(3, 2));
        System.out.println(leetCode0060.getPermutation(3, 3));
        System.out.println(leetCode0060.getPermutation(3, 4));
        System.out.println(leetCode0060.getPermutation(3, 5));
        System.out.println(leetCode0060.getPermutation(3, 6));
        System.out.println(leetCode0060.getPermutation(4, 7));
        System.out.println(leetCode0060.getPermutation(4, 9));
    }

}
