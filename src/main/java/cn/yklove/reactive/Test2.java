package cn.yklove.reactive;

/**
 * @author qinggeng
 */
public class Test2 {
    private static volatile int i = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int j = 0; j < 100; j++) {
            new Thread(() -> {
                for (int k = 0; k < 10000; k++) {
                    i++;
                }
            }).start();
        }
        Thread.sleep(5000);
        System.out.println(i);
    }
}
