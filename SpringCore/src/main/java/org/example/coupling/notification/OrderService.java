package org.example.coupling.notification;

public class OrderService {
    public void placeOrder(String channel) {
        System.out.println("Order placed.");

        // The order class knows every notification implementation and uses
        // an if/else decision to choose one. Adding WhatsApp would require
        // changing this business class, which is tight coupling.
        if ("sms".equalsIgnoreCase(channel)) {
            new SmsNotification().send("Your order is on its way.");
        } else {
            new EmailNotification().send("Thank you for your order.");
        }
    }
}
