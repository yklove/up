package cn.yklove.leetcode.contest.weekly188;

/**
 * @author qinggeng
 */
public class LeetCode2 {
    public static void main(String[] args) {
        LeetCode2 leetCode2 = new LeetCode2();
        System.out.println(leetCode2.countTriplets(new int[]{2, 3, 1, 6, 7}));
        System.out.println(leetCode2.countTriplets(new int[]{1, 1, 1, 1, 1}));
        System.out.println(leetCode2.countTriplets(new int[]{2,3}));
        System.out.println(leetCode2.countTriplets(new int[]{1,3,5,7,9}));
    }

    public int countTriplets(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int tmp = arr[i];
                for (int k = i + 1; k <= j; k++) {
                    tmp ^= arr[k];
                }
                if (tmp == 0) {
                    ans += (j - i);
                }
            }
        }
        return ans;
    }
}
