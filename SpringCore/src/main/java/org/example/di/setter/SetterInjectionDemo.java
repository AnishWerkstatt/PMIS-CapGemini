package org.example.di.setter;

public class SetterInjectionDemo {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        // The service is configured after construction through its setter.
        orderService.setNotificationService(new SmsNotification());
        orderService.placeOrder();
    }
}
