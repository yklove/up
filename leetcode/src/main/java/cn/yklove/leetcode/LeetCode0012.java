package cn.yklove.leetcode;

import java.util.TreeMap;

/**
 * @author qinggeng
 */
public class LeetCode0012 {

    private static final TreeMap<Integer,String> map = new TreeMap<>();
    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    public String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        while (num != 0){
            Integer key = map.floorKey(num);
            int k = num / key;
            for(int i=0;i<k;i++){
                stringBuilder.append(map.get(key));
            }
            num = num % key;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode0012().intToRoman(3));
        System.out.println(new LeetCode0012().intToRoman(4));
        System.out.println(new LeetCode0012().intToRoman(9));
        System.out.println(new LeetCode0012().intToRoman(58));
        System.out.println(new LeetCode0012().intToRoman(1994));
    }
}
