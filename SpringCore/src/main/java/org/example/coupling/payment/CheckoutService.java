package org.example.coupling.payment;

public class CheckoutService {
    public void checkout(double amount) {
        // CheckoutService is coupled directly to Stripe. Replacing Stripe
        // would force us to edit this class instead of only changing setup.
        StripePayment stripePayment = new StripePayment();
        stripePayment.pay(amount);
    }
}
