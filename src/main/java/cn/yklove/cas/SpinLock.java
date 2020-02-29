package cn.yklove.cas;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLock {
    private AtomicReference<Thread> cas = new AtomicReference<Thread>();

    public void lock() {
        Thread current = Thread.currentThread();
        // 利用CAS
        while (!cas.compareAndSet(null, current)) {
            // DO nothing
        }
        System.out.println(Thread.currentThread().getName() + " : 获取到锁");
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        cas.compareAndSet(current, null);
        System.out.println(Thread.currentThread().getName() + " : 释放掉锁");
        System.out.println();
    }

    public static void main(String[] args) {
        SpinLock lock = new SpinLock();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                lock.lock();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
                lock.unlock();
            }, "name = " + i).start();
        }

    }
}