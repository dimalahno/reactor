package sec01;

import reactor.core.publisher.Mono;

import static course_util.Util.*;

public class Lec04MonoEmptyOnError {

    public static void main(String[] args) {
        // 1 -> 2 -> 3
        userRepository(3)
                .subscribe(
                        onNext(),
                        onError(),
                        onComplete()
                );

    }

    private static Mono<String> userRepository(int userId) {
        if (userId == 1) {
            return Mono.just(faker().name().firstName());
        } else if (userId == 2){
            return Mono.empty(); // null
        } else {
            return Mono.error(new RuntimeException("Not in the allowed range"));
        }
    }
}
