package cn.yklove;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Ans1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        Interval[] intervals = new Interval[n];
        if (n == 0) {
            System.out.println(0);
            return;
        }
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            String[] split = s.split(",");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            intervals[i] = new Interval(x, y);
        }
        int i = eraseOverlapIntervals(intervals);
        System.out.println(i);
    }

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class myComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.end - b.end;
        }
    }

    public static int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new myComparator());
        int count = 1;
        Interval[] ttt = new Interval[intervals.length];
        ttt[0] = intervals[0];
        int tCount = 1;
        for (int i = 1; i < intervals.length; i++) {
            boolean key = true;
            for (int j = 0; j < tCount; j++) {
                // 满足条件
                if (intervals[i].start >= ttt[j].end) {
                    key = false;
                    ttt[j].end = intervals[i].end;
                    break;
                }
            }
            if (key) {
                count++;
            } else {
                ttt[tCount] = intervals[i];
                tCount++;
            }
        }
        return count;
    }
}
