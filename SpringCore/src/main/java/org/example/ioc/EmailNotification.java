package org.example.ioc;

public class EmailNotification implements NotificationService {
    @Override
    public void send(String message) {
        // The container chooses this implementation; OrderService does not.
        System.out.println("Email: " + message);
    }
}
