package org.example.ioc;

public interface NotificationService {
    // The container can wire any object that follows this contract.
    void send(String message);
}
