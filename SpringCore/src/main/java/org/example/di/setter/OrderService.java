package org.example.di.setter;

public class OrderService {
    private NotificationService notificationService;

    public void setNotificationService(NotificationService notificationService) {
        // This setter supplies the dependency after the object is created.
        this.notificationService = notificationService;
    }

    public void placeOrder() {
        // Setter injection allows an incomplete object, so fail clearly if
        // the application forgot to configure the required dependency.
        if (notificationService == null) {
            throw new IllegalStateException("Configure a notification service first.");
        }
        System.out.println("Order placed.");
        notificationService.send("Your order is on its way.");
    }
}
