package sec04;

import course_util.Util;
import sec04.helper.OrderService;
import sec04.helper.UserService;

public class Lec12FlatMap {

    public static void main(String[] args) {
        UserService.getUsers()
                .flatMap(user -> OrderService.getOrder(user.getUserId()))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }
}
