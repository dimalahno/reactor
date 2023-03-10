package sec05;

import course_util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec04HotPublisherAutoConnect {
    public static void main(String[] args) {
        Flux<String> movieStream = Flux.fromStream(Lec04HotPublisherAutoConnect::getMovies)
                .delayElements(Duration.ofSeconds(1))
                .publish()
                .autoConnect(0);

        Util.sleepSeconds(3);

        movieStream.subscribe(Util.subscriber("sam"));

        Util.sleepSeconds(10);

        System.out.println("Mike is about to join");

        movieStream.subscribe(Util.subscriber("mike"));

        Util.sleepSeconds(60);
    }

    private static Stream<String> getMovies() {
        System.out.println("Got the movie streaming request");
        return Stream.of("Scene 1",
                "Scene 2",
                "Scene 3",
                "Scene 4",
                "Scene 5",
                "Scene 6",
                "Scene 7"
        );
    }
}
