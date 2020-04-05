package cn.yklove;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TestAns2 {

    /*请完成下面这个函数，实现题目要求的功能
    5 5 2 2 4 5     -> 20
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static long countDolphin(int n, int m, int[] birthYear, int x) {
        if (m <= 0) {
            return 0;
        }
        Set<Integer> arraySet = new HashSet<>();
        for (int i : birthYear) {
            arraySet.add(i);
        }
        int[] ans = new int[m + 2];
        ans[1] = n;
        for (int i = 0; i < x; i++) {
            for (int j = m + 1; j > 0; j--) {
                ans[j] = ans[j - 1];
                ans[j - 1] = 0;
                if (arraySet.contains(j - 1)) {
                    ans[0] += ans[j];
                }
            }
        }
        int ansx = 0;
        for (int i = 0; i <= m + 1; i++) {
            ansx += ans[i];
        }
        return ansx;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long res;

        int _n;
        _n = in.nextInt();

        int _m;
        _m = in.nextInt();

        int _birthYear_size = 0;
        _birthYear_size = in.nextInt();
        int[] _birthYear = new int[_birthYear_size];
        int _birthYear_item;
        for (int _birthYear_i = 0; _birthYear_i < _birthYear_size; _birthYear_i++) {
            _birthYear_item = in.nextInt();
            _birthYear[_birthYear_i] = _birthYear_item;
        }

        int _x;
        _x = in.nextInt();

        res = countDolphin(_n, _m, _birthYear, _x);
        System.out.println(String.valueOf(res));

    }
}