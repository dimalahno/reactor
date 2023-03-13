package sec05;


import course_util.Util;
import sec05.assignment.InventoryService;
import sec05.assignment.OrderService;
import sec05.assignment.RevenueService;

public class Lec06Assignment {

    public static void main(String[] args) {

        OrderService orderService = new OrderService();
        RevenueService revenueService = new RevenueService();
        InventoryService inventoryService = new InventoryService();

        orderService.orderStream().subscribe(revenueService.subscribeOrderStream());
        orderService.orderStream().subscribe(inventoryService.subscribeOrderStream());

        inventoryService.inventoryStream().subscribe(Util.subscriber("inventory"));
        revenueService.revenueStream().subscribe(Util.subscriber("revenue"));

        Util.sleepSeconds(60);
    }
}
