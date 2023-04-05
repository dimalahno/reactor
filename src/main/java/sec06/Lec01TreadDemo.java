package sec06;

import course_util.Util;
import reactor.core.publisher.Flux;

public class Lec01TreadDemo {

    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
                    printThreadName("create");
                    fluxSink.next(1);
                })
                .doOnNext(i -> printThreadName("next " + 1));

        Runnable runnable = () -> flux.subscribe(v -> printThreadName("sub " + v));
        for (int i = 0; i < 2; i++) {
            new Thread(runnable).start();
        }

        Util.sleepSeconds(5);
    }

    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\t: Tread : " + Thread.currentThread().getName());
    }
}
