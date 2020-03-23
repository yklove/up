package cn.yklove.leetcode.contest.weekly181;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    public boolean hasValidPath(int[][] grid) {
        switch (grid[0][0]) {
            case 1:
                return f(grid, new Info(4, 0, 0));
            case 2:
            case 3:
                return f(grid, new Info(1, 0, 0));
            case 4:
                return f(grid, new Info(4, 0, 0)) ||
                        f(grid, new Info(1, 0, 0));
            case 6:
                return f(grid, new Info(4, 0, 0)) ||
                        f(grid, new Info(2, 0, 0));
            default:
                return false;
        }
    }

    private boolean f(int[][] grid, Info info) {
        if (info.x == grid.length - 1 && info.y == grid[0].length - 1) {
            return true;
        }
        switch (info.outDirection) {
            case 1:
                if (info.x + 1 > grid.length - 1) {
                    return false;
                }
                switch (grid[info.x + 1][info.y]) {
                    case 2:
                        return f(grid, new Info(1, info.x + 1, info.y));
                    case 5:
                        return f(grid, new Info(3, info.x + 1, info.y));
                    case 6:
                        return f(grid, new Info(4, info.x + 1, info.y));
                    default:
                        return false;
                }
            case 2:
                if (info.x - 1 < 0) {
                    return false;
                }
                switch (grid[info.x - 1][info.y]) {
                    case 2:
                        return f(grid, new Info(2, info.x - 1, info.y));
                    case 3:
                        return f(grid, new Info( 3, info.x - 1, info.y));
                    case 4:
                        return f(grid, new Info(4, info.x - 1, info.y));
                    default:
                        return false;
                }
            case 3:
                if (info.y - 1 < 0) {
                    return false;
                }
                switch (grid[info.x][info.y - 1]) {
                    case 1:
                        return f(grid, new Info(3, info.x, info.y - 1));
                    case 4:
                        return f(grid, new Info(1, info.x, info.y - 1));
                    case 6:
                        return f(grid, new Info(2, info.x, info.y - 1));
                    default:
                        return false;
                }
            case 4:
                if (info.y + 1 > grid[0].length - 1) {
                    return false;
                }
                switch (grid[info.x][info.y + 1]) {
                    case 1:
                        return f(grid, new Info(4, info.x, info.y + 1));
                    case 3:
                        return f(grid, new Info(1, info.x, info.y + 1));
                    case 5:
                        return f(grid, new Info(2, info.x, info.y + 1));
                    default:
                        return false;
                }
            default:
                return false;
        }
    }

    static class Info {
        int outDirection;
        int x;
        int y;

        public Info(int outDirection, int x, int y) {
            this.outDirection = outDirection;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        LeetCode3 leetCode3 = new LeetCode3();
        System.out.println(leetCode3.hasValidPath(new int[][]{{3, 4, 3, 4}, {2, 2, 2, 2}, {6, 5, 6, 5}}));

    }
}
