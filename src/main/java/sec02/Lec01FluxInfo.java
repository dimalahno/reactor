package sec02;

import course_util.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxInfo {

    public static void main(String[] args) {
        Flux<Integer> flux = Flux.just(1,2,3,4,5);
        flux.subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        Flux.empty();
    }
}
