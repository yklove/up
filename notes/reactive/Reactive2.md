### Flux与Mono

##### 1、描述

Reactor中的发布者（Publisher）由Flux和Mono两个类定义，它们都提供了丰富的操作符（operator）。

一个Flux对象代表一个包含0..N个元素的响应式序列，而一个Mono对象代表一个包含零/一个（0..1）元素的结果。

#### 2、信号

Flux和Mono都可以发出三种“数据信号”：元素值、错误信号、完成信号，错误信号和完成信号都是终止信号，
完成信号用于告知下游订阅者该数据流正常结束，错误信号终止数据流的同时将错误传递给下游订阅者。 
这三种信号都不是一定要具备的，终止信号只能存在一个，没有元素值的数据流是空数据流，没有终止信号的数据流是无限数据流。

#### 3、示例

###### 1、创建数据流
```java
// 创建数据流
Flux.just(1, 2, 3, 4, 5, 6);
Mono.just(1);   
// 其他方式
Integer[] array = new Integer[]{1,2,3,4,5,6};
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
```
###### 2、订阅

```java
Flux.just(1, 2, 3, 4, 5, 6).subscribe(System.out::print);
System.out.println();
Mono.just(1).subscribe(System.out::println);
```

###### 3、操作符（Operator）

1、`map`操作可以将数据元素进行转换/映射，得到一个新元素。

```java
StepVerifier.create(Flux.range(1, 6)
            .map(i -> i * i))
            .expectNext(1, 4, 9, 16, 25, 36)
            .expectComplete();
```

2、`flatMap`操作可以将每个数据元素转换/映射为一个流，然后将这些流合并为一个大的数据流。

```java
StepVerifier.create(
        Flux.just("flux", "mono")
                .flatMap(s -> Flux.fromArray(s.split("\\s*"))
                        .delayElements(Duration.ofMillis(100)))
                .doOnNext(System.out::print))
        .expectNextCount(8)
        .verifyComplete();
```

> 注意：`flatMap`是异步的，先来先到原则，并非是严格按照原始序列的顺序。 ????

3、`filter`操作可以对数据元素进行筛选。

```java
StepVerifier.create(Flux.range(1, 6)
            .filter(i -> i % 2 == 1)
            .map(i -> i * i))
            .expectNext(1, 9, 25)
            .verifyComplete();
```

4、`zip` 一对一合并，将多个流一对一的合并起来      