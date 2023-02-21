package sec01;

import course_util.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Lec05MonoFromSupplier {

    public static void main(String[] args) {

        // use just only when you have date already
//        Mono<String> mono = Mono.just(getName());

        Supplier<String> supplier = Lec05MonoFromSupplier::getName;

        Mono<String> monoFromSupplier = Mono.fromSupplier(supplier);
        monoFromSupplier.subscribe(
            Util.onNext()
        );

        Callable<String> stringCallable = Lec05MonoFromSupplier::getName;
        Mono.fromCallable(stringCallable)
                .subscribe(
                    Util.onNext()
                );
    }

    private static String getName() {
        System.out.println("Generating name ...");
        return Util.faker().name().fullName();
    }
}
