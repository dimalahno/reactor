package sec01;

import reactor.core.publisher.Mono;

public class Lec02MonoJust {

    public static void main(String[] args) {
        //publisher
        Mono<Integer> mono = Mono.just(1);

        mono.subscribe(i -> System.out.println("i = " + i));

    }
}
