package cn.yklove.reactive;

import org.junit.Test;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * @author qinggeng
 * @date 2019/12/27
 */
public class Reactor2 {

    @Test
    public void create() {
        // 创建数据流
        Flux.just(1, 2, 3, 4, 5, 6);
        Mono.just(1);

        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6};
        Flux.fromArray(array);
        List<Integer> list = Arrays.asList(array);
        Flux.fromIterable(list);
        Stream<Integer> stream = list.stream();
        Flux.fromStream(stream);
        // 只有完成信号的空数据流
        Flux.just();
        Flux.empty();
        Mono.empty();
        Mono.justOrEmpty(Optional.empty());
        // 只有错误信号的数据流
        Flux.error(new Exception("some error"));
        Mono.error(new Exception("some error"));
    }

    @Test
    public void subscribe() {
        Flux.just(1, 2, 3, 4, 5, 6).subscribe(System.out::print);
        System.out.println();
        Mono.just(1).subscribe(System.out::println);
        Flux.just(1, 2, 3, 4, 5, 6).subscribe(
                System.out::println,
                System.err::println,
                () -> System.out.println("Completed!"));
    }

    @Test
    public void testViaStepVerifier() {
        StepVerifier.create(Flux.just(1, 2, 3, 4, 5, 6))
                .expectNext(1, 2, 3, 4, 5, 6)
                .expectComplete()
                .verify();
        StepVerifier.create(Mono.error(new Exception("some error")))
                .expectErrorMessage("some error")
                .verify();
    }

    private Flux<String> getZipDescFlux() {
        String desc = "Zip two sources together, that is to say wait for all the sources to emit one element and combine these elements once into a Tuple2.";
        return Flux.fromArray(desc.split("\\s+"));  // 1
    }

    @Test
    public void testSimpleOperators() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Flux.zip(getZipDescFlux(),
                Flux.interval(Duration.ofMillis(200))
        ).subscribe(t -> System.out.println(t.getT1()), null, countDownLatch::countDown);
        countDownLatch.await(10, TimeUnit.SECONDS);
        countDownLatch = new CountDownLatch(1);
        getZipDescFlux().zipWith(Flux.interval(Duration.ofMillis(200)))
                .subscribe(t -> System.out.println(t.getT1()), null, countDownLatch::countDown);
        countDownLatch.await(10, TimeUnit.SECONDS);
    }

    @Test
    public void testFlatMap() {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        Flux.just("flux", "mono").flatMap(s -> {
            if (s.equals("flux")) {
                long i = 1000000L;
                while (i-- > 0) ;
            }
            return Flux.fromArray(s.split("\\s*"));
        }).subscribe(System.out::print);
        System.out.println("-------------");
        Flux.fromIterable(list).subscribe(i -> {
            System.out.print(i);
            i += 10000;
            while (i-- > 0) ;
        });

        System.out.println("-------------");

    }

    /**
     * 并不是在一个线程中执行的
     */
    @Test
    public void testDuration() {
        // 主线程
        System.out.println(Thread.currentThread().getName());
        // 线程parallel-1
        Flux.interval(Duration.ofMillis(2000)).subscribe(i -> {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        });
        // 线程parallel-2
        Flux.interval(Duration.ofMillis(2000)).subscribe(i -> {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        });
        while (true) ;
    }

    /**
     * 两处打印的线程名是一致的，但都不是主线程
     *
     * @throws InterruptedException
     */
    @Test
    public void testDuration2() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        getZipDescFlux().zipWith(Flux.interval(Duration.ofMillis(200)).doOnNext(i -> {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        })).subscribe(t -> System.out.println(Thread.currentThread().getName() + ":" + t.getT1() + ":" + t.getT2()), null, countDownLatch::countDown);
        countDownLatch.await(10, TimeUnit.SECONDS);
    }

    /**
     * 1是主线程
     * 2是不同的parallel-n线程
     * 3是不同的parallel-n线程,2和3是对应的
     * 疑问点testDuration2中是一个线程不断产生元素，而testDuration3却是多个线程
     * 总结：在处理一个元素的时候，会使用同一个线程
     */
    @Test
    public void testDuration3() {
        Flux.just("flux", "mono").flatMap(s -> {
            System.out.println("一:" + Thread.currentThread().getName() + ":" + s);// 1
            return Flux.fromArray(s.split("\\s*")).delayElements(Duration.ofMillis(100)).doOnNext(s1 -> {
                System.out.println("三:" + Thread.currentThread().getName() + ":" + s1);// 3
            });
        }).subscribe(s -> {
            System.out.println("二:" + Thread.currentThread().getName() + ":" + s);// 2
        });

        while (true) ;
    }

    private String getStringSync() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello, Reactor!";
    }

    @Test
    public void testSyncToAsync() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Mono.fromCallable(this::getStringSync)    // 1
                .subscribeOn(Schedulers.elastic())  // 2
                .subscribe(System.out::println, null, countDownLatch::countDown);
        countDownLatch.await(10, TimeUnit.SECONDS);
    }

    @Test
    public void testBackpressure() {
        Flux.range(1, 6)    // 1
                .doOnRequest(n -> System.out.println("Request " + n + " values..."))    // 2
                .subscribe(new BaseSubscriber<Integer>() {
                    @Override
                    protected void hookOnSubscribe(Subscription subscription) { // 4
                        System.out.println("Subscribed and make a request...");
                        request(1); // 5
                    }

                    @Override
                    protected void hookOnNext(Integer value) {  // 6
                        try {
                            TimeUnit.SECONDS.sleep(1);  // 7
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Get value [" + value + "]");    // 8
                        request(1); // 9
                    }
                });
    }


}
