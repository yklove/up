package cn.yklove;

/**
 * @author qinggeng
 */
public class Testtttt {

    static {
        System.out.println("静态代码块");
    }

    {
        System.out.println("非静态代码块");
    }

    public Testtttt() {
        System.out.println("构造方法");
    }

    public static void Test(){
        System.out.println("test");
    }
}
