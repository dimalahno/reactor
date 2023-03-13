package sec05;

import course_util.Util;
import reactor.core.publisher.Flux;

public class TestExample {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.create(fluxSink -> {
            System.out.println("created");
            for (int i = 0; i < 5; i++) {
                fluxSink.next(i);
            }
        });
        Flux<Integer> map = flux.map(i -> i * 2);
        map.subscribe(System.out::println);
        map.subscribe(System.out::println);


        Flux<Object> flux1 = Flux.create(fluxSink -> {
                    System.out.println("created1");
                    for (int i = 0; i < 5; i++) {
                        fluxSink.next(i);
                    }
                    fluxSink.complete();
                })
                .publish()
                .refCount(2);
        flux1.subscribe(System.out::println);
        flux1.subscribe(System.out::println);
        flux1.subscribe(System.out::println);

        System.out.println("----");
        Flux<Integer> flux2 = Flux.create(fluxSink -> {
            System.out.println("created2");
            for (int i = 0; i < 5; i++) {
                fluxSink.next(i);
            }
            fluxSink.complete();
        });
        Flux<Integer> cache = flux2.filter(i -> i > 1).cache(1);

        cache.subscribe(Util.subscriber());
        cache.subscribe(Util.subscriber());
    }
}
