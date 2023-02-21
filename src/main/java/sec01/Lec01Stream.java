package sec01;

import java.util.stream.Stream;

public class Lec01Stream {

    public static void main(String[] args) {

        Stream<Integer> stream = Stream.of(1).map(i -> i * 2);
        // Stream is lazy. It won't start to work until call terminal operator
        stream.forEach(System.out::println);
    }
}
