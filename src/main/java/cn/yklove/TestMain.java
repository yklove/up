package cn.yklove;

import java.math.BigInteger;
import java.util.Map;

/**
 * @author qinggeng
 */
public class TestMain {

    static {
        System.out.println("main静态代码块");
    }

    {
        System.out.println("main非静态代码块");
    }

    public TestMain() {
        System.out.println("main构造方法");
    }

    public static int countZeroNum2(int N) {
        int num = 0;
        while (N > 0) {
            num += (N / 5);
            N /= 5;
        }
        return num;
    }

    public static void main(String[] args) {
        Integer qiniu = Integer.valueOf("qiniu", 36);
        System.out.println(qiniu);
        int i = countZeroNum2(qiniu);
        System.out.println(i);

        BigInteger bigInteger = new BigInteger(qiniu.toString());
        BigInteger zror = new BigInteger("0");
        BigInteger xxx = new BigInteger("-1");
        BigInteger a = new BigInteger("1");
        for (; bigInteger.compareTo(zror) > 0; bigInteger = bigInteger.add(xxx)) {
            a = a.multiply(bigInteger);
        }
        System.out.println(a);
//        System.out.println(sqrt);
//        System.out.println("xxxx");
//        Testtttt.Test();
//        System.out.println("xxxx");
//
//        System.out.println(TestEnum1.TEST1.equals(TestEnum2.TEST1));
//        System.out.println(TestEnum1.TEST1 == TestEnum2.TEST1);
    }
}
