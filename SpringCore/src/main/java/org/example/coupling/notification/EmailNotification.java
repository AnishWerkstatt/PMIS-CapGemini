package org.example.coupling.notification;

public class EmailNotification {
    // Email is one possible notification channel.
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}
