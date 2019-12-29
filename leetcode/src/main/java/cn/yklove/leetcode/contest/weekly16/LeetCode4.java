package cn.yklove.leetcode.contest.weekly16;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author qinggeng
 */
public class LeetCode4 {

    HashSet<Character> characters = new HashSet<>();
    HashSet<Character> charactersNull = new HashSet<>();
    Map<Integer, Character> test = new HashMap<>();

    Long start = System.currentTimeMillis();

    public boolean isSolvable(String[] words, String result) {
        for (String word : words) {
            for (char c : word.toCharArray()) {
                characters.add(c);
            }
        }
        fun(words, result);
        System.out.println(System.currentTimeMillis() - start);
        return false;
    }

    private void fun(String[] words, String result) {
        if (charactersNull.size() == characters.size()) {


        }
        for (Character character : characters) {
            for (int i = 0; i < 10; i++) {
                if (charactersNull.contains(character)) {
                    break;
                }
                if (!test.containsKey(i)) {
                    test.put(i, character);
                    charactersNull.add(character);
                    fun(words, result);
                    test.remove(i);
                    charactersNull.remove(character);
                }
            }
        }
    }

    public static void main(String[] args) {
        new LeetCode4().isSolvable(new String[]{"SEND", "MORE"}, "MONEY");
    }
}
