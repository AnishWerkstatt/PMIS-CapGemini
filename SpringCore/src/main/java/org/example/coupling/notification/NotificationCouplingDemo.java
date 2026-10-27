package org.example.coupling.notification;

public class NotificationCouplingDemo {
    public static void main(String[] args) {
        // Running both calls shows that OrderService owns channel selection.
        new OrderService().placeOrder("email");
        new OrderService().placeOrder("sms");
    }
}
