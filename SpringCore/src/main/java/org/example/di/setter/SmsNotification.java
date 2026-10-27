package org.example.di.setter;

public class SmsNotification implements NotificationService {
    @Override
    public void send(String message) {
        // This implementation can be swapped without changing OrderService.
        System.out.println("SMS: " + message);
    }
}
