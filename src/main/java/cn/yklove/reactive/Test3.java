package cn.yklove.reactive;

import java.text.DecimalFormat;

/**
 * @author qinggeng
 */
public class Test3 {

    static int i = 1111;
    static {
        i = 0;  // 给变量赋值可以正常编译通过
//        System.out.println(i);  // 这句编译器会提示“非法向前引用”
    }

    public static void main(String[] args) {
//        System.out.println(i);
        System.out.println(Float2Binary(0.6f));
//        System.out.println(Integer.toBinaryString(17));
    }

    public static String Float2Binary(double n) {//使用double输入，不影响
        int signBit;//符号位
//        String s = Float.toString((float) n);  这个方法会自动用 科学记数法4.52E-4
        String s = (new DecimalFormat("################.######")).format(n);

        /**
         * 处理符号位
         * 本来是有正负0的，这个地方就默认是正0了
         */
        if (n == 0) {
            signBit = 0;
        } else if (n < 0) {
            signBit = 1;
            s = s.substring(1);//把负号去掉
        } else {
            signBit = 0;
        }

        /**
         * 不用判断是小数还是整数，Float.toString()会自动在整数后补0,0也一样
         * 将整数部分小数部分分开：
         */
        String intFloat[] = s.split("\\.");
        int intPart = Integer.valueOf(intFloat[0]);
        float floatPart = Float.valueOf("0." + intFloat[1]);
//        System.out.println(s);
//        System.out.println(intPart);
        //处理整数部分
        boolean isReady = false;
        String str_intpart = "";   //以1开头的二进制数 如10——>1010，而不是32位
        for (int i = 31; i >= 0; i--) {  //
            if (((intPart >> i) & 1) == 1) {
                isReady = true;
            }
            if (isReady) {
                str_intpart += ((intPart >> i) & 1) == 1 ? 1 : 0;
            }
        }

        //处理小数部分——乘2取整法
        String str_floartPart = "";
        while (floatPart != 0) {
            floatPart *= 2;
            if (floatPart >= 1) {
                floatPart -= 1;
                str_floartPart += 1;
            } else str_floartPart += 0;
        }

        /**
         * 规格化
         */
        String str_int_float = str_intpart + str_floartPart+"0000000000000000000000000000000"; //补0是因为可能不够长
        //现在得到二进制下的："整数(.)小数"格式。考虑规格化
        int diff = 0;//  规格化所要将小数部分移动的位数，主要是针对整数部分为0的
        int intlen = str_intpart.length();
        str_intpart = str_int_float.substring(0, 1);
        str_floartPart = str_int_float.substring(1,23);
        while (str_intpart.charAt(0) != '1') {
            str_intpart = str_floartPart.substring(0, 1);
            str_floartPart = str_floartPart.substring(1);
            diff++;
        }

        int expChange = intlen != 0 ? intlen - 1 : -diff - 1;  //规格化所带来的指数的移动

        //得到8位指数部分；
        int exponential = expChange + 127;//真正的指数
        String exp = "";  //指数
        for (int i = 7; i >= 0; i--) {
            exp += ((exponential >> i) & 1) == 1 ? 1 : 0;
        }

        //得到23位底数部分
        String base = str_floartPart;
        int len = base.length();
        for (int i = 0; i < 23 - len; i++) {
            base += 0;
        }

        return signBit + " " + exp + " " + base;
    }

}
