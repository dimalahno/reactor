package sec01;

import reactor.core.publisher.Mono;

import static course_util.Util.*;

public class Lec03MonoSubscribe {
    public static void main(String[] args) {
        Mono<Integer> mono = Mono.just("ball")
                .map(String::length)
                .map(integer -> integer/2);

        mono.subscribe(
                onNext(),
                onError(),
                onComplete()
        );
    }
}
