package cn.yklove.leetcode.contest.weekly177;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author qinggeng
 */
public class LeetCode4 {

    private String removeAndPrintResult(int[] digits,
                                        int ind1, int ind2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i != ind1 && i != ind2) {
                stringBuilder.append(digits[i]);
            }
        }
        return stringBuilder.toString();
    }

    public String largestMultipleOfThree(int[] digits) {
        // 对数组求和
        int sum = 0;
        for (int i : digits) {
            sum += i;
        }
        // 情况①，倒序返回数组即可
        if (sum % 3 == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = digits.length - 1; i >= 0; i--) {
                stringBuilder.append(digits[i]);
            }
            return stringBuilder.toString();
        }
        // 从小到大排序
        Arrays.sort(digits);
        int remainder = sum % 3;

        // 情况②
        if (remainder == 1) {
            int[] rem_2 = new int[2];
            rem_2[0] = -1;
            rem_2[1] = -1;
            // 遍历整个数组
            for (int i = 0; i < digits.length; i++) {
                // 情况②中的第一种情况。如果找到一个数字余数是1，删除这个数字即可
                if (digits[i] % 3 == 1) {
                    return removeAndPrintResult(digits, i, -1);
                }
                // 情况②中的第二种情况。如果这个数字余数是2，记录下来，如果找到了两个余数是2的数字，删除这两个数字即可
                if (digits[i] % 3 == 2) {
                    // 保存第一个余数是2的数字
                    if (rem_2[0] == -1) {
                        rem_2[0] = i;
                    }
                    // 保存第二个余数是2的数字
                    else if (rem_2[1] == -1) {
                        rem_2[1] = i;
                    }
                }
            }
            // 如果找到了两个余数是2的数字，删除这俩数组就是答案
            if (rem_2[0] != -1 &&
                    rem_2[1] != -1) {
                return removeAndPrintResult(digits, rem_2[0],
                        rem_2[1]);
            }
        }
        // 情况③。如果余数是2
        else if (remainder == 2) {
            int[] rem_1 = new int[2];
            rem_1[0] = -1;
            rem_1[1] = -1;
            // 遍历数组
            for (int i = 0; i < digits.length; i++) {
                // 情况③中的第一种情况。找到一个余数是2的数字，删除即可
                if (digits[i] % 3 == 2) {
                    return removeAndPrintResult(digits, i, -1);
                }
                // 情况③中的第二种。尝试寻找两个余数是1的数组，删掉这俩数组也可以
                if (digits[i] % 3 == 1) {
                    if (rem_1[0] == -1) {
                        rem_1[0] = i;
                    } else if (rem_1[1] == -1) {
                        rem_1[1] = i;
                    }
                }
            }
            if (rem_1[0] != -1 &&
                    rem_1[1] != -1) {
                return removeAndPrintResult(digits, rem_1[0],
                        rem_1[1]);
            }
        }
        // 其余情况没有答案
        return "";
    }


    public static void main(String[] args) {
//        int arr[] = {5,5,5,5,5};
//        int n = arr.length;
//        System.out.println(largest3Multiple(arr, n));;
    }
}
