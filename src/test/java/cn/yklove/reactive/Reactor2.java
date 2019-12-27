package cn.yklove.reactive;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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


}
