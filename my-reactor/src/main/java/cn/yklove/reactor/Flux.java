package cn.yklove.reactor;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

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
}
