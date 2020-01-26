package cn.yklove.leetcode.contest.weekly173;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Info> infoList = new ArrayList<>();
        for (int[] restaurant : restaurants) {
            infoList.add(new Info(restaurant[0], restaurant[1], restaurant[2], restaurant[3], restaurant[4]));
        }
        return infoList.stream()
                .filter(info -> {
                    if (veganFriendly == 0) {
                        return true;
                    }
                    return info.veganFriendly == 1;
                })
                .filter(info -> info.price <= maxPrice)
                .filter(info -> info.distance <= maxDistance)
                .sorted((o1, o2) -> {
                    int compare = Integer.compare(o2.rating, o1.rating);
                    if (compare != 0) {
                        return compare;
                    }
                    return Integer.compare(o2.id, o1.id);
                })
                .map(Info::getId).collect(Collectors.toList());
    }

    static class Info {
        public Info(int id, int rating, int veganFriendly, int price, int distance) {
            this.id = id;
            this.rating = rating;
            this.veganFriendly = veganFriendly;
            this.price = price;
            this.distance = distance;
        }

        private int id;
        private int rating;
        private int veganFriendly;
        private int price;
        private int distance;

        public int getId() {
            return id;
        }
    }

    public static void main(String[] args) {

    }


}
