package sec02;

import course_util.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class Lec03FluxFromArrayList {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "b", "c");

        Flux.fromIterable(strings)
                .subscribe(Util.onNext());

        Integer[] arr = {2, 5, 7,9};

        Flux.fromArray(arr).subscribe(Util.onNext());
    }
}
