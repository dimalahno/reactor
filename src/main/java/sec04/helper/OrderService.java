package sec04.helper;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {

    private static final Map<Integer, List<PurchasedOrder>> db = new HashMap<>();

    static {
        List<PurchasedOrder> orderList1 = Arrays.asList(
                new PurchasedOrder(1),
                new PurchasedOrder(1),
                new PurchasedOrder(1)
        );
        List<PurchasedOrder> orderList2 = Arrays.asList(
                new PurchasedOrder(2),
                new PurchasedOrder(2)
        );
        db.put(1, orderList1);
        db.put(2, orderList2);
    }

    public static Flux<PurchasedOrder> getOrder(int userId) {
        return Flux.create((FluxSink<PurchasedOrder> purchasedOrderFluxSink) -> {
           db.get(userId).forEach(purchasedOrderFluxSink::next);
           purchasedOrderFluxSink.complete();
        })
                .delayElements(Duration.ofSeconds(1));
    }
}
