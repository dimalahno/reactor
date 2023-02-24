package sec02;

import course_util.Util;
import sec02.helper.NameGenerator;

import java.util.List;

public class Lec07FluxVsList {

    public static void main(String[] args) {
        // List blocking
        List<String> names = NameGenerator.getNames(5);
        System.out.println("names = " + names);

        // Flux non blocking
        NameGenerator.getNamesFlux(5)
                .subscribe(Util.onNext());
    }
}
