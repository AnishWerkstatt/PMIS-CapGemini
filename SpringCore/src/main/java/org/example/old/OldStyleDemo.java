package org.example.old;

public class OldStyleDemo {
    public static void main(String[] args) {
        // The application creates the main service, but the service creates
        // its own EmailSender internally.
        new OrderService().placeOrder();
    }
}
