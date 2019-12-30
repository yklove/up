package cn.yklove.reactor;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author qinggeng
 */
public abstract class Flux<T> implements Publisher<T> {

    @Override
    public abstract void subscribe(Subscriber<? super T> s);

    public static <T> Flux<T> just(T... data) {
        return new FluxArray<>(data);
    }

    public <V> Flux<V> map(Function<? super T, ? extends V> mapper) {
        return new FluxMap<>(this, mapper);
    }

    public Flux<T> filter(Predicate<? super T> p) {
        return new FluxFilter<>(this, p);
    }

    public void subscribe(Consumer<? super T> consumer) {
        this.subscribe(new LambdaSubscriber<>(consumer));
    }

    public void subscribe(Consumer<? super T> consumer,
                          Consumer<? super Throwable> errorConsumer) {
        this.subscribe(new LambdaSubscriber<>(consumer,errorConsumer));
    }

    public void subscribe(Consumer<? super T> consumer,
                          Consumer<? super Throwable> errorConsumer,
                          Runnable completeConsumer) {
        this.subscribe(consumer,errorConsumer,completeConsumer);
    }

    public void subscribe(Consumer<? super T> consumer,
                          Consumer<? super Throwable> errorConsumer,
                          Runnable completeConsumer,
                          Consumer<? super Subscription> subscriptionConsumer) {
        this.subscribe(consumer,errorConsumer,completeConsumer,subscriptionConsumer);
    }
}
