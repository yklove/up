package cn.yklove.leetcode.L0063;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qinggeng
 */
public class SolutionTest {

    @Test
    public void uniquePathsWithObstacles() {
        Solution solution = new Solution();
        Assert.assertEquals(solution.uniquePathsWithObstacles(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        }), 2);
        Assert.assertEquals(solution.uniquePathsWithObstacles(new int[][]{
                {1},
        }), 0);
    }
}