package org.example.di.constructor;

public class EmailNotification implements NotificationService {
    @Override
    public void send(String message) {
        // The implementation detail is kept outside OrderService.
        System.out.println("Email: " + message);
    }
}
