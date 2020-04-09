package cn.yklove.leetcode;

/**
 * Alice 和 Bob 用几堆石子在做游戏。几堆石子排成一行，每堆石子都对应一个得分，由数组 stoneValue 给出。
 * <p>
 * Alice 和 Bob 轮流取石子，Alice 总是先开始。在每个玩家的回合中，该玩家可以拿走剩下石子中的的前 1、2 或 3 堆石子 。比赛一直持续到所有石头都被拿走。
 * <p>
 * 每个玩家的最终得分为他所拿到的每堆石子的对应得分之和。每个玩家的初始分数都是 0 。比赛的目标是决出最高分，得分最高的选手将会赢得比赛，比赛也可能会出现平局。
 * <p>
 * 假设 Alice 和 Bob 都采取 最优策略 。如果 Alice 赢了就返回 "Alice" ，Bob 赢了就返回 "Bob"，平局（分数相同）返回 "Tie" 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/stone-game-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author qinggeng
 */
public class LeetCode1406 {

    /**
     * 动态规划
     * 拿第i堆石子时获得的最大分数
     * dp[i] = Max(sum - dp[i+1] , sum - dp[i+2] , sum - dp[i+3])
     * 其中sum表示从第i堆石子到第n堆石子分数之和。
     * 可以看到这个表达式需要倒着算。
     * 根据题意可知Alice先拿第一堆，所以只需要看看第一堆的分数和剩下的分数的大小即可知道答案
     *
     * @param stoneValue
     * @return
     */
    public String stoneGameIII(int[] stoneValue) {
        int[] dp = new int[stoneValue.length + 1];
        int sum = 0;
        for (int i = stoneValue.length - 1; i >= 0; i--) {
            sum += stoneValue[i];
            dp[i] = Integer.MIN_VALUE;
            for (int j = 1; j <= 3 && i + j <= stoneValue.length; j++) {
                dp[i] = Math.max(sum - dp[i + j], dp[i]);
            }
        }
        int score = dp[0];
        if (sum - score == score) {
            return "Tie";
        } else if (sum - score < score) {
            return "Alice";
        } else {
            return "Bob";
        }
    }

    public static void main(String[] args) {
        LeetCode1406 leetCode1406 = new LeetCode1406();
        System.out.println("Bob".equals(leetCode1406.stoneGameIII(new int[]{1, 2, 3, 7})));
        System.out.println("Alice".equals(leetCode1406.stoneGameIII(new int[]{1, 2, 3, -9})));
        System.out.println("Tie".equals(leetCode1406.stoneGameIII(new int[]{1, 2, 3, 6})));
        System.out.println("Alice".equals(leetCode1406.stoneGameIII(new int[]{1, 2, 3, -1, -2, -3, 7})));
    }
}
