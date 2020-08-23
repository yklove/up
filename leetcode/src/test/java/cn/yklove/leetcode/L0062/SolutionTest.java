package cn.yklove.leetcode.L0062;


import org.junit.Assert;
import org.junit.Test;

/**
 * @author qinggeng
 */
public class SolutionTest {

    @Test
    public void uniquePaths() {
        Solution solution = new Solution();
        Assert.assertEquals(solution.uniquePaths(3, 2), 3);
        Assert.assertEquals(solution.uniquePaths(7, 3), 28);
    }
}