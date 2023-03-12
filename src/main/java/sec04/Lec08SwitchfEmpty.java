package sec04;

import course_util.Util;
import reactor.core.publisher.Flux;

public class Lec08SwitchfEmpty {
    public static void main(String[] args) {
        getOrderNumbers()
                .filter(i -> i > 10)
                .switchIfEmpty(fallback())
                .subscribe(Util.subscriber());
    }

    private static Flux<Integer> getOrderNumbers() {
        return Flux.range(1, 10);
    }

    private static Flux<Integer> fallback() {
        return Flux.range(20, 5);
    }

}
