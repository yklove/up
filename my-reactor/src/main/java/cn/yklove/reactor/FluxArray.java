package cn.yklove.reactor;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * @author qinggeng
 */
public class FluxArray<T> extends Flux<T> {

    private T[] array;

    public FluxArray(T[] data) {
        this.array = data;
    }

    @Override
    public void subscribe(Subscriber<? super T> s) {
        s.onSubscribe(new ArraySubscription<>(s,array));
    }

    static final class ArraySubscription<T> implements Subscription {

        private final Subscriber<? super T> s;

        private final T[] array;

        private int index;

        private boolean canceled;

        public ArraySubscription(Subscriber<? super T> s, T[] array) {
            this.s = s;
            this.array = array;
        }

        @Override
        public void request(long n) {
            if (canceled) {
                return;
            }
            long length = array.length;
            for (int i = 0; i < n && index < length; i++) {
                s.onNext(array[index++]);  // 3
            }
            if (index == length) {
                s.onComplete();    // 4
            }
        }

        @Override
        public void cancel() {
            this.canceled = true;
        }
    }
}
