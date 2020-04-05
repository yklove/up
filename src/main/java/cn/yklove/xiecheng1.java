package cn.yklove;

import java.util.*;

public class xiecheng1 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        String[] s;
        int[] result = new int[num];
        int res = 0;
        String a = in.nextLine();
        for (int i = 0; i < num; i++) {
            s = in.nextLine().split(",");
            for (int j = 0; j < num; j++) {
                if (Integer.valueOf(s[0]) >= result[j]) {
                    result[j] = Integer.valueOf(s[1]);
                    if (j + 1 > res) {
                        res = j + 1;
                    }
                    break;
                }
            }
        }
        System.out.println(res);
    }
}