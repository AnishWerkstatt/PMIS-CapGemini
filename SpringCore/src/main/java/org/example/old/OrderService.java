package org.example.old;

public class OrderService {
    public void placeOrder() {
        System.out.println("Order placed.");

        // OrderService creates the object it needs. It is like a chef
        // leaving the kitchen during every order to buy a new oven.
        // This is the starting point that will lead us to Dependency Injection.
        EmailSender emailSender = new EmailSender();
        emailSender.send("Thank you for your order.");
    }
}
