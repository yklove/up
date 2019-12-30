package cn.yklove.reactor;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.function.Predicate;

/**
 * @author qinggeng
 */
public class FluxFilter<T> extends Flux<T> {

    private final Flux<? extends T> source;

    private final Predicate<? super T> p;

    public FluxFilter(Flux<T> source, Predicate<? super T> p) {
        this.source = source;
        this.p = p;
    }

    @Override
    public void subscribe(Subscriber<? super T> s) {
        source.subscribe(new FilterSubscriber(s, p));
    }

    static final class FilterSubscriber<T> implements Subscriber<T>, Subscription {

        private final Subscriber<? super T> actual;
        private final Predicate<? super T> p;

        boolean done;

        Subscription subscriptionOfUpstream;

        FilterSubscriber(Subscriber<? super T> actual, Predicate<? super T> p) {
            this.actual = actual;
            this.p = p;
        }

        @Override
        public void onSubscribe(Subscription s) {
            this.subscriptionOfUpstream = s;
            actual.onSubscribe(s);
        }

        @Override
        public void onNext(T t) {
            if (done) {
                return;
            }
            if (p.test(t)) {
                actual.onNext(t);
            }
            request(1);
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

        @Override
        public void request(long n) {
            subscriptionOfUpstream.request(n);
        }

        @Override
        public void cancel() {
            subscriptionOfUpstream.cancel();
        }
    }
}
