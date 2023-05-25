package sec06;

import course_util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec03SubscribeOnMultipleItems {

    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
                    printThreadName("create");
                    fluxSink.next(1);
                })
                .doOnNext(i -> printThreadName("next " + 1));

        flux.subscribeOn(Schedulers.boundedElastic())
                .subscribe(v -> printThreadName("sub " + v));

        Util.sleepSeconds(5);
    }

    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\t: Tread : " + Thread.currentThread().getName());
    }

}
