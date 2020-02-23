package cn.yklove.reactive;

/**
 * @author qinggeng
 */
public class Test {
    static final Object object = new Object();

    public static void main(String[] args) {
        char[] c1 = {'a', 'b', 'c'};
        char[] c2 = {'1', '2', '3'};
        Thread thread1 = new Thread(new TestRunnable(c1));
        Thread thread2 = new Thread(new TestRunnable(c2));
        thread1.start();
        thread2.start();
    }

    static class TestRunnable implements Runnable {
        private char[] c;

        public TestRunnable(char[] c) {
            this.c = c;
        }

        @Override
        public void run() {
            synchronized (object) {
                try {
                    for (char c1 : c) {
                        object.notify();
                        System.out.println(c1);
                        object.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
