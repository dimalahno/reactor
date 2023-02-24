package sec02;

import course_util.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Lec04FluxFromStream {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Stream<Integer> stream = list.stream();
        // stream.forEach(System.out::println); // stream closed
        // stream.forEach(System.out::println); // throw exception

        // When second time used catch error
        // Error : stream has already been operated upon or closed
        // Flux<Integer> flux = Flux.fromStream(stream);

        Flux<Integer> flux = Flux.fromStream(list::stream); // Use Supplier !!!

        flux.subscribe(Util.onNext(), Util.onError(),Util.onComplete());
        flux.subscribe(Util.onNext(),  Util.onError(), Util.onComplete());

    }
}
