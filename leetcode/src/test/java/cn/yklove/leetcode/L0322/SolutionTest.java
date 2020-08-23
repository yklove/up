package cn.yklove.leetcode.L0322;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qinggeng
 */
public class SolutionTest {

    @Test
    public void coinChange() {
        Solution solution = new Solution();
        Assert.assertEquals(solution.coinChange(new int[]{186, 419, 83, 408}, 6249), 20);
        Assert.assertEquals(solution.coinChange(new int[]{1}, 2), 2);
        Assert.assertEquals(solution.coinChange(new int[]{1, 2, 5}, 11), 3);
        Assert.assertEquals(solution.coinChange(new int[]{2}, 3), -1);
        Assert.assertEquals(solution.coinChange(new int[]{1}, 0), 0);
    }
}