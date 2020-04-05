package cn.yklove.leetcode.contest.weekly182;

/**
 * @author qinggeng
 */
public class LeetCode2 {


    public int numTeams(int[] rating) {
        int count = 0;
        for (int i = 0; i < rating.length - 2; i++) {
            for (int j = i + 1; j < rating.length - 1; j++) {
                for (int k = j+1; k < rating.length; k++) {
                    if (rating[i] < rating[j] && rating[j] < rating[k]
                            || rating[i] > rating[j] && rating[j] > rating[k]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }


//    public int[] lengthOfLIS(int[] nums) {
//
//        int[] dp = new int[nums.length];
//        dp[0] = 1;
//        for (int i = 1; i < nums.length; i++) {
//            dp[i] = 1;
//            for (int j = 0; j <= i - 1; j++) {
//                if (nums[i] < nums[j] && dp[j] + 1 > dp[i]) {
//                    dp[i] = dp[j] + 1;
//                }
//                if (dp[i] == 3) {
//                    this.count++;
//                }
//            }
//        }
//        return dp;
//    }
//
//    public int[] lengthOfLIS2(int[] nums) {
//
//        int[] dp = new int[nums.length];
//        dp[0] = 1;
//        for (int i = 1; i < nums.length; i++) {
//            dp[i] = 1;
//            for (int j = 0; j <= i - 1; j++) {
//                if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
//                    dp[i] = dp[j] + 1;
//                }
//                if (dp[i] == 3) {
//                    this.count++;
//                }
//            }
//        }
//        return dp;
//    }

    public static void main(String[] args) {
        LeetCode2 leetCode2 = new LeetCode2();
        System.out.println(leetCode2.numTeams(new int[]{2, 5, 3, 4, 1}));
    }
}
