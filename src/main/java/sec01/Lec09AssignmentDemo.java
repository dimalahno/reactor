package sec01;

import course_util.Util;
import sec01.assignment.FileService;

public class Lec09AssignmentDemo {

    public static final String FILE_1 = "file01.txt";
    public static final String FILE_2 = "file02.txt";

    public static void main(String[] args) {

        FileService.read(FILE_1)
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        FileService.write(FILE_2, "This is file02")
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        FileService.read(FILE_2)
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        FileService.delete(FILE_2)
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

    }
}
