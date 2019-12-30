package cn.yklove.webfluxwithlatency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@SpringBootApplication
@RestController
public class WebfluxWithLatencyApplication {


    public static void main(String[] args) {
        SpringApplication.run(WebfluxWithLatencyApplication.class, args);
    }

    @GetMapping("/hello/{latency}")
    public Mono<String> hello(@PathVariable int latency) {
        return Mono.just("Welcome to reactive world ~")
                .delayElement(Duration.ofMillis(latency)); // 1
    }

    @GetMapping("/hello2/{latency}")
    public Mono<String> hello2(@PathVariable int latency) {
        return Mono.fromCallable(() -> {
            TimeUnit.MILLISECONDS.sleep(latency);
            return "Welcome to reactive world ~";
        }).subscribeOn(Schedulers.elastic()); // 1
    }
}
