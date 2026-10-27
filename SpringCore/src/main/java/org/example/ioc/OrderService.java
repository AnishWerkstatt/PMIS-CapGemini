package org.example.ioc;

public class OrderService {
    private final NotificationService notificationService;

    public OrderService(NotificationService notificationService) {
        // The container calls this constructor and supplies the dependency.
        this.notificationService = notificationService;
    }

    public void placeOrder() {
        System.out.println("Order placed.");
        // Business code is independent of object creation and wiring.
        notificationService.send("Your order was wired by the container.");
    }
}
