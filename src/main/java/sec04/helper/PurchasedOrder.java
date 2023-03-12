package sec04.helper;

import course_util.Util;
import lombok.Data;

@Data
public class PurchasedOrder {
    private String item;
    private double price;
    private int userId;

    public PurchasedOrder(int userId) {
        this.userId = userId;
        this.item = Util.faker().commerce().productName();
        this.price = Double.parseDouble(Util.faker().commerce().price().replace(',', '.'));
    }
}
