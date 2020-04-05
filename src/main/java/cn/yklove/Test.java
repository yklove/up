package cn.yklove;

import java.util.Scanner;

/**
 * @author qinggeng
 */
public class Test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int c1 = in.nextInt();
        int c2 = in.nextInt();
        int h1 = in.nextInt();
        int h2 = in.nextInt();
        System.out.println(Math.max(c1, c2) <= Math.min(h1, h2) ? "YES" : "NO");
    }


}
