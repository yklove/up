package cn.yklove.reactor;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.function.Function;

/**
 * @author qinggeng
 */
public class FluxMap<T, R> extends Flux<R> {

    private final Flux<? extends T> source;
    private final Function<? super T, ? extends R> mapper;


    public FluxMap(Flux<T> source, Function<? super T, ? extends R> mapper) {
        this.source = source;
        this.mapper = mapper;
    }

    @Override
    public void subscribe(Subscriber<? super R> s) {
        source.subscribe(new MapSubscriber<>(s, mapper));
    }

    static final class MapSubscriber<T, R> implements Subscriber<T>, Subscription {
        private final Subscriber<? super R> actual;
        private final Function<? super T, ? extends R> mapper;

        boolean done;

        Subscription subscriptionOfUpstream;

        MapSubscriber(Subscriber<? super R> actual, Function<? super T, ? extends R> mapper) {
            this.actual = actual;
            this.mapper = mapper;
        }

        @Override
        public void request(long n) {   // 1
            this.subscriptionOfUpstream.request(n);
        }

        @Override
        public void cancel() {
            this.subscriptionOfUpstream.cancel();
        }

        @Override
        public void onSubscribe(Subscription s) {
            this.subscriptionOfUpstream = s;    // 1
            actual.onSubscribe(this);           // 2
        }

        @Override
        public void onNext(T t) {
            if (done) {
                return;
            }
            actual.onNext(mapper.apply(t));
        }

        @Override
        public void onError(Throwable t) {
            if (done) {
                return;
            }
            done = true;
            actual.onError(t);
        }

        @Override
        public void onComplete() {
            if (done) {
                return;
            }
            done = true;
            actual.onComplete();
        }
    }

}
