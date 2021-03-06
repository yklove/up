# 反应式编程（Reactive programming）

## 什么是反应式编程？

> [wikipedia](https://zh.wikipedia.org/wiki/%E5%93%8D%E5%BA%94%E5%BC%8F%E7%BC%96%E7%A8%8B)在计算机中，
> 响应式编程或反应式编程（英语：Reactive programming）是一种面向数据流和变化传播的编程范式。
> 这意味着可以在编程语言中很方便地表达静态或动态的数据流，而相关的计算模型会自动将变化的值通过数据流进行传播。

## 反应式系统

> [反应式宣言](https://www.reactivemanifesto.org/zh-CN)

##### 反应式系统的特质：

1. 即时响应性(Responsive)：只要有可能， 系统就会及时地做出响应。
2. 回弹性(Resilient)：系统在出现失败时依然保持即时响应性。
3. 弹性(Elastic)：系统在不断变化的工作负载之下依然保持即时响应性。
4. 消息驱动(Message Driven)：反应式系统依赖异步的消息传递，从而确保了松耦合、隔离、位置透明的组件之间有着明确边界。

> 即时响应性: ：只要有可能， 系统就会及时地做出响应。 即时响应是可用性和实用性的基石， 而更加重要的是，即时响应意味着可以快速地检测到问题并且有效地对其进行处理。 即时响应的系统专注于提供快速而一致的响应时间， 确立可靠的反馈上限， 以提供一致的服务质量。 这种一致的行为转而将简化错误处理、 建立最终用户的信任并促使用户与系统作进一步的互动。

> 回弹性：系统在出现失败时依然保持即时响应性。 这不仅适用于高可用的、 任务关键型系统——任何不具备回弹性的系统都将会在发生失败之后丢失即时响应性。 回弹性是通过复制、 遏制、 隔离以及委托来实现的。 失败的扩散被遏制在了每个[组件](/glossary.zh-cn.md#组件)内部， 与其他组件相互隔离， 从而确保系统某部分的失败不会危及整个系统，并能独立恢复。 每个组件的恢复都被委托给了另一个（外部的）组件， 此外，在必要时可以通过复制来保证高可用性。 （因此）组件的客户端不再承担组件失败的处理。

> 弹性： 系统在不断变化的工作负载之下依然保持即时响应性。 反应式系统可以对输入（负载）的速率变化做出反应，比如通过增加或者减少被分配用于服务这些输入（负载）的资源。 这意味着设计上并没有争用点和中央瓶颈， 得以进行组件的分片或者复制， 并在它们之间分布输入（负载）。 通过提供相关的实时性能指标， 反应式系统能支持预测式以及反应式的伸缩算法。 这些系统可以在常规的硬件以及软件平台上实现成本高效的弹性。

> 消息驱动：反应式系统依赖异步的消息传递，从而确保了松耦合、隔离、位置透明的组件之间有着明确边界。 这一边界还提供了将失败作为消息委托出去的手段。 使用显式的消息传递，可以通过在系统中塑造并监视消息流队列， 并在必要时应用回压， 从而实现负载管理、 弹性以及流量控制。 使用位置透明的消息传递作为通信的手段， 使得跨集群或者在单个主机中使用相同的结构成分和语义来管理失败成为了可能。 非阻塞的通信使得接收者可以只在活动时才消耗资源， 从而减少系统开销。

## Reactive Streams

> [反应流规范](https://www.reactive-streams.org/)

> Reactive Streams是一项倡议，旨在为具有无阻塞背压的异步流处理提供标准。这包括针对运行时环境（JVM和JavaScript）以及网络协议的工作。

总之，Reactive Streams 是针对面向流的 JVM 库的标准和规范。

##### 四项原则：

- 处理数量可能无限的元素
- 有序的
- 在组件之间异步传递元素
- 有强制性的非阻塞背压

## 异步非阻塞

> 阻塞和非阻塞反映的是调用者的状态，当调用者调用了服务提供者的方法后，如果一直在等待结果返回，否则无法执行后续的操作，那就是阻塞状态；
> 如果调用之后直接返回，从而可以继续执行后续的操作，那可以理解为非阻塞的。

> 同步和异步反映的是服务提供者的能力，当调用者调用了服务提供者的方法后，如果服务提供者能够立马返回，并在处理完成后通过某种方式通知到调用者，
> 那可以理解为异步的；否则，如果只是在处理完成后才返回，或者需要调用者再去主动查询处理是否完成，就可以理解为是同步的。

> 多线程的弊端：多线程的切换会消耗CPU资源、更多的线程意味着更多的内存占用

异步非阻塞的代码可以在不改变执行线程的情况下切换要执行的任务