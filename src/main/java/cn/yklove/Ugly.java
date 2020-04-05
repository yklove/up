package cn.yklove;

import java.math.BigInteger;

class Ugly {
    public BigInteger[] nums = new BigInteger[7789];

    Ugly() {
        nums[0] = new BigInteger("1");
        BigInteger ugly;
        int i2 = 0, i3 = 0, i5 = 0;

        for (int i = 1; i < 7789; ++i) {
            ugly =
                    nums[i2].multiply(new BigInteger("2"))
                            .min(nums[i3].multiply(new BigInteger("3")))
                            .min(nums[i5].multiply(new BigInteger("7")));
            nums[i] = ugly;

            if (ugly.equals(nums[i2].multiply(new BigInteger("2")))) ++i2;
            if (ugly.equals(nums[i3].multiply(new BigInteger("3")))) ++i3;
            if (ugly.equals(nums[i5].multiply(new BigInteger("7")))) ++i5;
        }
    }
}

class Solution {
    public static Ugly u = new Ugly();

    public BigInteger nthUglyNumber(int n) {
        return u.nums[n];
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().nthUglyNumber(1));
//        System.out.println(new Solution().nthUglyNumber(2));
//        System.out.println(new Solution().nthUglyNumber(3));
//        System.out.println(new Solution().nthUglyNumber(10));
        for (int i = 1; i <= 10; i++) {
            System.out.println(new Solution().nthUglyNumber(i));
        }
//        System.out.println(new Solution().nthUglyNumber(7776));
//        System.out.println(new Solution().nthUglyNumber(7777));
        System.out.println(new Solution().nthUglyNumber(7776));
        System.out.println(new Solution().nthUglyNumber(7777));
        System.out.println(new Solution().nthUglyNumber(7778));
    }
}
