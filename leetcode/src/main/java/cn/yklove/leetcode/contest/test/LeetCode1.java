package cn.yklove.leetcode.contest.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    private static List<List<Integer>> list = new ArrayList<>();
    private static List<List<Integer>> list2 = new ArrayList<>();

    static void arrange(int a[], int start, int end) {
        List<Integer> tmp = new ArrayList<>();
        if (start == end) {
            for (int i : a) {
                tmp.add(i);
            }
            list.add(tmp);
            list2.add(tmp);
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(a, i, start);
            arrange(a, start + 1, end);
            swap(a, i, start);
        }
    }

    static void swap(int arr[], int i, int j) {
        int te = arr[i];
        arr[i] = arr[j];
        arr[j] = te;
    }

    public int expectNumber(int[] scores) {
        Arrays.sort(scores);
        int start = -1;
        int ans = 0;
        for (int score : scores) {
            if (score != start) {
                ans++;
            }
            start = score;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1 leetCode1 = new LeetCode1();
        System.out.println(leetCode1.expectNumber(new int[]{1, 2, 3}));
        System.out.println(leetCode1.expectNumber(new int[]{1, 1}));
        System.out.println(leetCode1.expectNumber(new int[]{1, 1, 2}));
//        arrange(new int[]{1,2},0,1);
//        arrange(new int[]{1,2,3,4},0,3);
//        System.out.println(list);
//        int count = 0;
//        int t = 0;
//        for (List<Integer> integers : list) {
//            for (List<Integer> integerList : list2) {
//                count++;
//                for (int i = 0; i < integers.size(); i++) {
//                    if(integers.get(i).equals(integerList.get(i))){
//                        t++;
//                    }
//                }
//            }
//        }
//        System.out.println(t/count);
    }
}
