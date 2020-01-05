package cn.yklove.leetcode.contest.weekly170;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    public static void main(String[] args) {
        List<String> strings = new LeetCode3().watchedVideosByFriends(
                Arrays.asList(Arrays.asList("A", "B"), Arrays.asList("C")
                        , Arrays.asList("B", "C"), Arrays.asList("D")), new int[][]{{1, 2}, {0, 3}, {0, 3}, {1, 2}}
                , 0, 1);
        System.out.println(strings);
    }

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos,
                                              int[][] friends,
                                              int id,
                                              int level) {
        Map<Integer, Figure> map = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            Figure figure = new Figure();
            figure.id = i;
            map.put(i, figure);
        }
        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends[i].length; j++) {
                map.get(i).nextList.add(map.get(friends[i][j]));
            }
            map.get(i).watchedVideos.addAll(watchedVideos.get(i));
        }
        Queue<Figure> queue = new LinkedList<>();
        int levelCount = 1;
        queue.add(map.get(id));
        Figure end = new Figure();
        queue.add(end);
        while (!queue.isEmpty()) {
            Figure poll = queue.poll();
            if (poll == end) {
                levelCount++;
                continue;
            }
            for (Figure figure : poll.nextList) {
                if (figure.level == 0) {
                    figure.level = levelCount;
                    queue.add(figure);
                }
            }
        }
        map.get(id).level = 0;
        Map<String, Wacth> ans = new HashMap<>();
        for (Map.Entry<Integer, Figure> integerFigureEntry : map.entrySet()) {
            if (integerFigureEntry.getValue().level == level) {
                for (String watchedVideo : integerFigureEntry.getValue().watchedVideos) {
                    if (ans.containsKey(watchedVideo)) {
                        ans.get(watchedVideo).count += 1;
                    } else {
                        Wacth wacth = new Wacth();
                        wacth.name = watchedVideo;
                        wacth.count = 1;
                        ans.put(watchedVideo, wacth);
                    }
                }
            }
        }
        List<Wacth> list = new ArrayList<>(ans.values());
        Collections.sort(list, (o1, o2) -> {
            int compare = Integer.compare(o1.count, o2.count);
            if (compare != 0) {
                return compare;
            }
            return o1.name.compareTo(o2.name);
        });
        return list.stream().map(wacth -> wacth.getName()).collect(Collectors.toList());
    }

    static class Wacth {
        String name;
        int count;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    static class Figure {
        private int id;
        private int level;
        private Set<Figure> nextList = new HashSet<>();
        private Set<String> watchedVideos = new HashSet<>();
    }
}
