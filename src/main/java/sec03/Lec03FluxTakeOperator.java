package sec03;

import course_util.Util;
import reactor.core.publisher.Flux;

public class Lec03FluxTakeOperator {

    public static void main(String[] args) {
        // map
        // filter

        Flux.range(1, 10)
                .log()
                .take(3) // cancel
                .log()
                .subscribe(Util.subscriber());
    }




}
