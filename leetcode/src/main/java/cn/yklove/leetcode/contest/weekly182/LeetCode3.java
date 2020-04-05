package cn.yklove.leetcode.contest.weekly182;

import java.util.*;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();

        Scanner in = new Scanner(System.in);
        String x = in.nextLine();
        String y = in.nextLine();
        x = x.substring(1, x.length() - 1);
        String[] split = x.split(",");
        y = y.substring(1, y.length() - 2);
        String[] split1 = y.split("\\],\\[");
        for (int i = 1; i < split.length; i++) {
            String s = split[i];
            s = s.substring(1, s.length() - 1);
            String s1 = split1[i];
            String[] split2 = s1.split(",");
            switch (s) {
                case "checkIn":
                    undergroundSystem.checkIn(Integer.parseInt(split2[0]), split2[1].substring(0, split2[1].length() - 1), Integer.parseInt(split2[2]));
                    break;
                case "checkOut":
                    undergroundSystem.checkOut(Integer.parseInt(split2[0]), split2[1].substring(0, split2[1].length() - 1), Integer.parseInt(split2[2]));
                    break;
                case "getAverageTime":
                    System.out.println(undergroundSystem.getAverageTime(split2[0].substring(0, split2[0].length() - 1), split2[1].substring(0, split2[1].length() - 1)));
                    break;
            }
        }


//        undergroundSystem.checkIn(45, "Leyton", 3);
//        undergroundSystem.checkIn(32, "Paradise", 8);
//        undergroundSystem.checkIn(27, "Leyton", 10);
//        undergroundSystem.checkOut(45, "Waterloo", 15);
//        undergroundSystem.checkOut(27, "Waterloo", 20);
//        undergroundSystem.checkOut(32, "Cambridge", 22);
//        System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge"));
//        ;
//        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
//        ;
//        undergroundSystem.checkIn(10, "Leyton", 24);
//        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
//        ;
//        undergroundSystem.checkOut(10, "Waterloo", 38);
//        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
//        ;

    }

    static class UndergroundSystem {

        class Info {
            Integer id;
            String stationName;
            String stationName2;
            Integer t;
            Integer t2;

            public Info(Integer id, String stationName, String stationName2, Integer t, Integer t2) {
                this.id = id;
                this.stationName = stationName;
                this.stationName2 = stationName2;
                this.t = t;
                this.t2 = t2;
            }
        }

        Map<Integer, Info> map;
        List<Info> list;

        public UndergroundSystem() {
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        public void checkIn(int id, String stationName, int t) {
            map.put(id, new Info(id, stationName, null, t, 0));
        }

        public void checkOut(int id, String stationName, int t) {
            map.get(id).t2 = t;
            map.get(id).stationName2 = stationName;
            list.add(map.get(id));
            map.remove(id);
        }

        public double getAverageTime(String startStation, String endStation) {
            int time = 0;
            int count = 0;
            for (Info value : list) {
                if (startStation.equals(value.stationName) && endStation.equals(value.stationName2)) {
                    time += value.t2 - value.t;
                    count++;
                }
            }
            double v = (double) time / (double) count;
            return v;
        }
    }


}
