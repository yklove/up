package cn.yklove.leetcode.contest.weekly177;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author qinggeng
 */
public class LeetCode4 {


    // Number of digits
    static int MAX_SIZE = 10;

    // function to sort array of digits using
    // counts
    static void sortArrayUsingCounts(int arr[],
                                     int n) {
        // Store count of all elements
        int[] count = new int[MAX_SIZE];
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        // Store
        int index = 0;
        for (int i = 0; i < MAX_SIZE; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }

    static String removeAndPrintResult(int arr[], int n,
                                     int ind1, int ind2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            if (i != ind1 && i != ind2) {
                stringBuilder.append(arr[i]);
            }
        }
        return stringBuilder.toString();
    }

    static String largest3Multiple(int arr[],
                                   int n) {
        Arrays.sort(arr);

        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        if (sum % 3 == 0) {
            if(sum == 0){
                return "0";
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = arr.length - 1; i >= 0; i--) {
                stringBuilder.append(arr[i]);
            }
            return stringBuilder.toString();
        }

        // Find reminder
        int remainder = sum % 3;

        // If remainder is '1', we have to
        // delete either one element of
        // remainder '1' or two elements of
        // remainder '2'
        if (remainder == 1) {
            int[] rem_2 = new int[2];
            rem_2[0] = -1;
            rem_2[1] = -1;
            // 遍历整个数组
            for (int i = 0; i < n; i++) {
                // 如果找到一个数字余数是1，删除这个数字即可
                if (arr[i] % 3 == 1) {
                    return removeAndPrintResult(arr, n, i, -1);
                }
                // 如果这个数字余数是2，记录下来，如果找到了两个余数是2的数字，删除这两个数字即可
                if (arr[i] % 3 == 2) {
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
                return removeAndPrintResult(arr, n, rem_2[0],
                        rem_2[1]);
            }
        }
        // 如果余数是2
        else if (remainder == 2) {
            int[] rem_1 = new int[2];
            rem_1[0] = -1;
            rem_1[1] = -1;
            // 遍历数组
            for (int i = 0; i < n; i++) {
                // 找到一个余数是2的数字，删除即可
                if (arr[i] % 3 == 2) {
                    return removeAndPrintResult(arr, n, i, -1);
                }
                // 尝试寻找两个余数是1的数组，删掉这俩数组也可以
                if (arr[i] % 3 == 1) {
                    if (rem_1[0] == -1) {
                        rem_1[0] = i;
                    }
                    else if (rem_1[1] == -1) {
                        rem_1[1] = i;
                    }
                }
            }
            if (rem_1[0] != -1 &&
                    rem_1[1] != -1) {
                return removeAndPrintResult(arr, n, rem_1[0],
                        rem_1[1]);
            }
        }
        // 其余情况没有答案
        return "";
    }

    public String largestMultipleOfThree(int[] digits) {
        return largest3Multiple(digits,digits.length);
    }


    public static void main(String[] args) {
        int arr[] = {5,5,5,5,5};
        int n = arr.length;
        System.out.println(largest3Multiple(arr, n));;
    }
}
