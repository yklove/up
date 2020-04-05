package cn.yklove.leetcode.contest.weekly183;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    public String longestDiverseString(int a, int b, int c) {
        List<Info> list = new ArrayList<>();
        list.add(new Info('a', a));
        list.add(new Info('b', b));
        list.add(new Info('c', c));
        list.sort((o1, o2) -> Integer.compare(o2.count, o1.count));
        StringBuilder stringBuilder = new StringBuilder();
        Info info = list.get(0);
        Info info2 = list.get(1);
        Info info3 = list.get(2);
        for (int i = 0; i < info.count; i++) {
            stringBuilder.append(info.c);
        }
        info.count = 0;
        int i = 0;
        int count = 0;
        while (i < stringBuilder.length()) {
            if (stringBuilder.charAt(i) == info.c) {
                count++;
            } else {
                count = 0;
            }
            if (count == 2) {
                if (info2.count >= 2) {
                    stringBuilder.insert(i + 1, info2.c).insert(i + 1, info2.c);
                    info2.count -= 2;
                } else if (info3.count >= 2) {
                    stringBuilder.insert(i + 1, info3.c).insert(i + 1, info3.c);
                    info3.count -= 2;
                } else if (info2.count == 1) {
                    stringBuilder.insert(i + 1, info2.c);
                    info2.count -= 1;
                } else if (info3.count == 1) {
                    stringBuilder.insert(i + 1, info3.c);
                    info3.count -= 1;
                } else {
                    info.count += stringBuilder.length() - (i+1);
                    stringBuilder.delete(i + 1, stringBuilder.length());
                }
                count = 0;
            }
            i++;
        }
        if (stringBuilder.length() == 0) {
            return "";
        }
        i = 0;
        while (i < stringBuilder.length() - 1) {
            if (i == 0 && stringBuilder.charAt(i + 1) != info2.c) {
                if (info2.count >= 2) {
                    stringBuilder.insert(i + 1, info2.c).insert(i + 1, info2.c);
                    info2.count -= 2;
                } else if (info2.count == 1) {
                    stringBuilder.insert(i + 1, info2.c);
                    info2.count -= 1;
                }
            } else if (i > 0 && stringBuilder.charAt(i) != info2.c && stringBuilder.charAt(i + 1) != info2.c) {
                if (info2.count >= 2) {
                    stringBuilder.insert(i + 1, info2.c).insert(i + 1, info2.c);
                    info2.count -= 2;
                } else if (info2.count == 1) {
                    stringBuilder.insert(i + 1, info2.c);
                    info2.count -= 1;
                }
            }
            i++;
        }
        if (stringBuilder.charAt(stringBuilder.length() - 1) != info2.c) {
            if (info2.count >= 2) {
                stringBuilder.append(info2.c).append(info2.c);
                info2.count -= 2;
            } else if (info2.count == 1) {
                stringBuilder.append(info2.c);
                info2.count -= 1;
            }
        }

        i = 0;
        while (i < stringBuilder.length() - 1) {
            if (i == 0 && stringBuilder.charAt(i + 1) != info3.c) {
                if (info3.count >= 2) {
                    stringBuilder.insert(i + 1, info3.c).insert(i + 1, info3.c);
                    info3.count -= 2;
                } else if (info3.count == 1) {
                    stringBuilder.insert(i + 1, info3.c);
                    info3.count -= 1;
                }
            } else if (i > 0 && stringBuilder.charAt(i) != info3.c && stringBuilder.charAt(i + 1) != info3.c) {
                if (info3.count >= 2) {
                    stringBuilder.insert(i + 1, info3.c).insert(i + 1, info3.c);
                    info3.count -= 2;
                } else if (info3.count == 1) {
                    stringBuilder.insert(i + 1, info3.c);
                    info3.count -= 1;
                }
            }
            i++;
        }
        if (stringBuilder.charAt(stringBuilder.length() - 1) != info3.c) {
            if (info3.count >= 2) {
                stringBuilder.append(info3.c).append(info3.c);
                info3.count -= 2;
            } else if (info3.count == 1) {
                stringBuilder.append(info3.c);
                info3.count -= 1;
            }
        }

        i = 0;
        while (i < stringBuilder.length() - 1) {
            if (i == 0 && stringBuilder.charAt(i + 1) != info.c) {
                if (info.count >= 2) {
                    stringBuilder.insert(i + 1, info.c).insert(i + 1, info.c);
                    info.count -= 2;
                } else if (info.count == 1) {
                    stringBuilder.insert(i + 1, info.c);
                    info.count -= 1;
                }
            } else if (i > 0 && stringBuilder.charAt(i) != info.c && stringBuilder.charAt(i + 1) != info.c) {
                if (info.count >= 2) {
                    stringBuilder.insert(i + 1, info.c).insert(i + 1, info.c);
                    info.count -= 2;
                } else if (info.count == 1) {
                    stringBuilder.insert(i + 1, info.c);
                    info.count -= 1;
                }
            }
            i++;
        }
        if (stringBuilder.charAt(stringBuilder.length() - 1) != info.c) {
            if (info.count >= 2) {
                stringBuilder.append(info.c).append(info.c);
                info.count -= 2;
            } else if (info.count == 1) {
                stringBuilder.append(info.c);
                info.count -= 1;
            }
        }
        return stringBuilder.toString();
    }

    class Info {
        char c;
        int count;

        public Info(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        LeetCode3 leetCode3 = new LeetCode3();
//        System.out.println(leetCode3.longestDiverseString(0, 9, 12));
        System.out.println(leetCode3.longestDiverseString(0, 8, 11));
//        System.out.println(leetCode3.longestDiverseString(4, 4, 3));
//        System.out.println(leetCode3.longestDiverseString(1, 1, 7));
//        System.out.println(leetCode3.longestDiverseString(2, 2, 1));
//        System.out.println(leetCode3.longestDiverseString(7, 1, 0));
    }
}
