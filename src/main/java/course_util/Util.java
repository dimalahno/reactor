package course_util;

import com.github.javafaker.Faker;

import java.util.function.Consumer;

public class Util {

    public static final Faker FAKER = Faker.instance();

    public static Consumer<Object> onNext() {
        return object -> System.out.println("Received : " + object);
    }

    public static Consumer<Throwable> onError() {
        return error -> System.out.println("Error : " + error.getMessage());
    }

    public static Runnable onComplete() {
        return () -> System.out.println("Completed");
    }

    public static Faker faker() {
        return FAKER;
    }
}
