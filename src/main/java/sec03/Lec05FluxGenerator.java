package sec03;

import course_util.Util;
import lombok.val;
import reactor.core.publisher.Flux;

public class Lec05FluxGenerator {
    public static void main(String[] args) {
        Flux.generate(synchronousSink ->{
                    System.out.println("emitting");
                    synchronousSink.next(Util.faker().ancient().hero()); // 1
//                    synchronousSink.complete();
//                    synchronousSink.error(new RuntimeException("oops"));
                })
                .take(2)
                .subscribe(Util.subscriber());
    }
}
