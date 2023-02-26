package sec03;

import course_util.Util;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class LEc06FluxGenerateAssignment {

    public static void main(String[] args) {

        // canada
        // max = 10
        // subscriber cancel -> exit
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Flux.generate(synchronousSink -> {
            String country = Util.faker().country().name();
            System.out.println("emitting : " + country);
            synchronousSink.next(country);
            atomicInteger.incrementAndGet();
            if (country.equalsIgnoreCase("canada"))
                synchronousSink.complete();
        }).subscribe(Util.subscriber());
    }
}
