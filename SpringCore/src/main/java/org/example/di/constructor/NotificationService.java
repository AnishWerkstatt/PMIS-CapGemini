package org.example.di.constructor;

public interface NotificationService {
    // This is a contract: any channel that can send a notification
    // can be used by OrderService.
    void send(String message);
}
