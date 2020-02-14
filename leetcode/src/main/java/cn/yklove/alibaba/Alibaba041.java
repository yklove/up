package cn.yklove.alibaba;

/**
 * @author qinggeng
 */
public class Alibaba041 {

    public int solution(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        boolean key = false;
        do {
            key = false;
            for (int i = 1; i < stringBuilder.length(); ) {
                if (stringBuilder.charAt(i - 1) != stringBuilder.charAt(i)) {
                    key = true;
                    stringBuilder.replace(i - 1, i + 1, "");
                } else {
                    i++;
                }
            }
        } while (key);
        return str.length() - stringBuilder.length();
    }

    public static void main(String[] args) {
        Alibaba041 alibaba041 = new Alibaba041();
        System.out.println(alibaba041.solution("AABB"));
        System.out.println(alibaba041.solution("A"));
        System.out.println(alibaba041.solution("AAAA"));
        System.out.println(alibaba041.solution("ABB"));
    }
}
