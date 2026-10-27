package org.example.coupling.notification;

public class SmsNotification {
    // SMS is another possible channel, but it has no common interface yet.
    public void send(String message) {
        System.out.println("SMS: " + message);
    }
}
