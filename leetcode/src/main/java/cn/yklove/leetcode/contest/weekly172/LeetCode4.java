package cn.yklove.leetcode.contest.weekly172;

/**
 * @author qinggeng
 */
public class LeetCode4 {

    private int[] ranges;
    private int n;

    public int minTaps(int n, int[] ranges) {
        this.ranges = ranges;
        this.n = n;
        Info f = f(null, 0, 0);
        Info f1 = f(null, 1, 0);
        if (f == null && f1 == null) {
            return -1;
        }
        if (f == null) {
            return f1.count;
        }
        if (f1 == null) {
            return f.count;
        }
        return Math.min(f.count, f1.count);
    }

    private Info f(Info info, int off, int i) {
        Info t = new Info();
        if (off == 1) {
            if (info == null) {
                t.start = i - ranges[i];
                t.end = i + ranges[i];
                t.count++;
            } else {
                t = info;
                t.start = Math.min(t.start, i - ranges[i]);
                t.end = Math.max(t.end, i + ranges[i]);
                t.count++;
            }
        } else {
            t = info;
        }
        if (i >= n) {
            return t;
        }
        Info f = f(t, 0, i + 1);
        Info f1 = f(t, 1, i + 1);
        if (f == null && f1 == null) {
            return null;
        }
        if (f == null) {
            return f1;
        }
        if (f1 == null) {
            return f;
        }
        if (f.count > f1.count) {
            return f1;
        } else if(f.count == f1.count){
            return f;
        } else{
            return f;
        }
    }

    static class Info {
        int start;
        int end;
        int count;
    }


    public static void main(String[] args) {
//        System.out.println(new LeetCode4().minTaps(5,new int[]{3,4,1,1,0,0}));
        System.out.println(new LeetCode4().minTaps(1, new int[]{0, 0}));
    }
}
