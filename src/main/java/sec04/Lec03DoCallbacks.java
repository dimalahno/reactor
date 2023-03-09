package sec04;

import course_util.Util;
import reactor.core.publisher.Flux;

public class Lec03DoCallbacks {

    public static void main(String[] args) {

        Flux.create(fluxSink -> {
                    for (int i = 0; i < 5; i++) {
                        fluxSink.next(i);
                    }
//                    fluxSink.complete();
                    fluxSink.error(new RuntimeException("oops"));
                    System.out.println("--completed--");
                })
                .doOnComplete(() -> System.out.println("doOnComplete"))
                .doFirst(() -> System.out.println("doFirst 1"))
                .doOnNext(o -> System.out.println("doOnNext = " + o))
                .doOnSubscribe(s -> System.out.println("doOnSubscribe 1 = " + s))
                .doOnRequest(rec -> System.out.println("doOnRequest = " + rec))
                .doOnError(error -> System.out.println("doOnError = " + error))
//                .doFirst(() -> System.out.println("doFirst 2"))
                .doOnTerminate(() -> System.out.println("doOnTerminate"))
                .doOnCancel(() -> System.out.println("doOnCancel"))
//                .doOnSubscribe(s -> System.out.println("doOnSubscribe 2 = " + s))
                .doFinally(signal -> System.out.println("doFinally 1 = " + signal))
                .doOnDiscard(Object.class, o -> System.out.println("doOnDiscard = " + o))
                .doFirst(() -> System.out.println("doFirst 3"))
                .take(2)
                .doFinally(signal -> System.out.println("doFinally 2 = " + signal))
                .subscribe(Util.subscriber());
    }
}
