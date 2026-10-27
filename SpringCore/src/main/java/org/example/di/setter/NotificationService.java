package org.example.di.setter;

public interface NotificationService {
    // OrderService needs only this capability, regardless of the channel.
    void send(String message);
}
