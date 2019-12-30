package cn.yklove.reactor;

import org.junit.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.Assert.*;

/**
 * @author qinggeng
 */
public class FluxTest {

    @Test
    public void just() {

        Flux.just(1, 2, 3, 4, 5).subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                System.out.println("onSubscribe");
                s.request(3);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext:" + integer);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }

    @Test
    public void map() {
        Flux.just(1, 2, 3, 4, 5)
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) {
                        return integer + 1;
                    }
                })
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        System.out.println("onSubscribe");
                        s.request(3);
                    }

                    @Override
                    public void onNext(Integer o) {
                        System.out.println("onNext:" + o);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });
    }

    @Test
    public void filter() {
        Flux.just(1, 2, 3, 4, 5, 6)
                .filter(integer -> integer % 2 == 0)
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        System.out.println("onSubscribe");
                        s.request(1);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext:" + integer);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {
                        System.out.println("complete");
                    }
                });
    }
}