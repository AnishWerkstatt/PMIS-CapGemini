package org.example.coupling.testing;

public class TestingCouplingDemo {
    public static void main(String[] args) {
        // The result is tied to the real inventory implementation.
        boolean valid = new OrderValidator().isValid("Laptop");
        System.out.println("Order valid: " + valid);
    }
}
