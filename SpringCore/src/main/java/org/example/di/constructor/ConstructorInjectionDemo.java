package org.example.di.constructor;

public class ConstructorInjectionDemo {
    public static void main(String[] args) {
        // The composition root is the place where implementations are chosen.
        NotificationService notification = new EmailNotification();
        // Supplying the dependency from outside is Dependency Injection.
        OrderService orderService = new OrderService(notification);
        orderService.placeOrder();
    }
}
