package cn.yklove;

import java.util.Scanner;

/**
 * @author qinggeng
 */
public class Test3 {

    public static void main(String[] args) {

        String s1 = "abc";
        String s2 = new String("abc");
        String s3 = "ab";
        String s4 = "c";
        System.out.println(s1 == s2);
        System.out.println(s1 .equals(s2) );
        System.out.println(s1 == s3 + s4);
        System.out.println(s1.equals(s3+s4));


        System.out.println("BYTE MAX_VALUE = " + Byte.MAX_VALUE);
        System.out.println("BYTE MIN_VALUE = " + Byte.MIN_VALUE);
        System.out.println("SHORT MAX_VALUE = " + Short.MAX_VALUE);//3万多，5位
        System.out.println("SHORT MIN_VALUR = " + Short.MIN_VALUE);
        System.out.println("Int MAX_VALUE = " + Integer.MAX_VALUE);//21亿，10位
        System.out.println("Int MIN_VALUE = " + Integer.MIN_VALUE);
        System.out.println("LONG MAX_VALUE = " + Long.MAX_VALUE);//9.。。，19位
        System.out.println("LONG MIN_VALUR = " + Long.MIN_VALUE);
        System.out.println("FLOAT MAX_VALUE = " + Float.MAX_VALUE);
        System.out.println("FLOAT MIN_VALUE = " + Float.MIN_VALUE);
        System.out.println("DOUBLE MAX_VALUE = " + Double.MAX_VALUE);
        System.out.println("DOUBLE MIN_VALUR = " + Double.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE > Float.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE < Float.MAX_VALUE);
    }
}
