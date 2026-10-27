package org.example.di.constructor;

public class OrderService {
    // The service depends on an abstraction, not specifically on email.
    private final NotificationService notificationService;

    public OrderService(NotificationService notificationService) {
        // This is constructor injection: the dependency is supplied by the
        // caller, like giving a tool to a worker before the work begins.
        this.notificationService = notificationService;
    }

    public void placeOrder() {
        System.out.println("Order placed.");
        // OrderService only knows the contract and does not create a sender.
        notificationService.send("Thank you for your order.");
    }
}
