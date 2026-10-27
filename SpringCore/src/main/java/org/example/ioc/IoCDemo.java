package org.example.ioc;

public class IoCDemo {
    public static void main(String[] args) {
        // The container now controls creation and wiring: this is IoC.
        SimpleContainer container = new SimpleContainer();
        // The application asks for a ready object instead of assembling it.
        container.get(OrderService.class).placeOrder();
    }
}
