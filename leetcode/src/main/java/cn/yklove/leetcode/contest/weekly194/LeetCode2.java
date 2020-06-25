package cn.yklove.leetcode.contest.weekly194;


import java.util.*;

/**
 * @author qinggeng
 */
public class LeetCode2 {

    public String[] getFolderNames(String[] names) {
        String[] ans = new String[names.length];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (!map.containsKey(name)) {
                ans[i] = name;
                map.put(name, 1);
            } else {
                Integer integer = map.get(name);
                ans[i] = name + "(" + integer + ")";
                while (map.containsKey(ans[i])) {
                    ans[i] = name + "(" + ++integer + ")";
                }
                map.put(ans[i], integer - 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        for (String folderName : new LeetCode2().getFolderNames(new String[]{"kaido", "kaido(1)", "kaido", "kaido(1)"})) {
            System.out.print(folderName + " ");
        }
        System.out.println();
        for (String folderName : new LeetCode2().getFolderNames(new String[]{"pes", "fifa", "gta", "pes(2019)"})) {
            System.out.print(folderName + " ");
        }
        System.out.println();
        for (String folderName : new LeetCode2().getFolderNames(new String[]{"gta", "gta(1)", "gta", "avalon"})) {
            System.out.print(folderName + " ");
        }
        System.out.println();
        for (String folderName : new LeetCode2().getFolderNames(new String[]{"kaido", "kaido(1)", "kaido", "kaido(1)", "kaido(2)"})) {
            System.out.print(folderName + " ");
        }
        System.out.println();
    }

}
