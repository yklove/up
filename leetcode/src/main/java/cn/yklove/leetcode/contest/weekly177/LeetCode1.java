package cn.yklove.leetcode.contest.weekly177;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author qinggeng
 */
public class LeetCode1 {

    public int daysBetweenDates(String date1, String date2) {
        String pat = "yyyy-MM-dd";
        SimpleDateFormat format2 = new SimpleDateFormat(pat);
        try {
            Date a = format2.parse(date1);
            Date b = format2.parse(date2);
            Calendar c = Calendar.getInstance();
            long betweenDate = (b.getTime() - a.getTime()) / (60 * 60 * 24 * 1000);
            return Math.abs((int) betweenDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        LeetCode1 leetCode1 = new LeetCode1();
        System.out.println(leetCode1.daysBetweenDates("2019-06-29", "2019-06-30"));
        System.out.println(leetCode1.daysBetweenDates("2020-01-15", "2019-12-31"));
    }
}
