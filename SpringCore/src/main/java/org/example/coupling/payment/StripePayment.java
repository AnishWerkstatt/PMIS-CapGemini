package org.example.coupling.payment;

public class StripePayment {
    // This concrete class represents one payment provider.
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Stripe.");
    }
}
