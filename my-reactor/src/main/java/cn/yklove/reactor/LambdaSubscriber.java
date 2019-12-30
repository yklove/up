package cn.yklove.reactor;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.function.Consumer;

/**
 * @author qinggeng
 */
public class LambdaSubscriber<T> implements Subscriber<T> {

    private final Consumer<? super T> consumer;
    private final Consumer<? super Throwable> errorConsumer;
    private final Runnable completeConsumer;
    private final Consumer<? super Subscription> subscriptionConsumer;

    public LambdaSubscriber(Consumer<? super T> consumer) {
        this(consumer, null, null, null);
    }

    public LambdaSubscriber(Consumer<? super T> consumer, Consumer<? super Throwable> errorConsumer) {
        this(consumer, errorConsumer, null, null);
    }

    public LambdaSubscriber(Consumer<? super T> consumer, Consumer<? super Throwable> errorConsumer, Runnable completeConsumer) {
        this(consumer, errorConsumer, completeConsumer, null);
    }

    public LambdaSubscriber(Consumer<? super T> consumer, Consumer<? super Throwable> errorConsumer, Runnable completeConsumer, Consumer<? super Subscription> subscriptionConsumer) {
        this.consumer = consumer;
        this.errorConsumer = errorConsumer;
        this.completeConsumer = completeConsumer;
        this.subscriptionConsumer = subscriptionConsumer;
    }

    @Override
    public void onSubscribe(Subscription s) {
        if (subscriptionConsumer != null) {
            subscriptionConsumer.accept(s);
        } else {
            s.request(Long.MAX_VALUE);
        }
    }

    @Override
    public void onNext(T t) {
        if (consumer != null) {
            consumer.accept(t);
        }
    }

    @Override
    public void onError(Throwable t) {
        if (errorConsumer != null) {
            errorConsumer.accept(t);
        }
    }

    @Override
    public void onComplete() {
        if (completeConsumer != null) {
            completeConsumer.run();
        }
    }
}
