package org.example.coupling.payment;

public class PaymentCouplingDemo {
    public static void main(String[] args) {
        // The demo is simple, but the hidden Stripe dependency is the problem.
        new CheckoutService().checkout(499.0);
    }
}
