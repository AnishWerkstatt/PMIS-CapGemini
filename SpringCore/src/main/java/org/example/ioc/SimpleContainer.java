package org.example.ioc;

import java.util.HashMap;
import java.util.Map;

public class SimpleContainer {
    // A real Spring container has a much richer registry. This map is enough
    // to demonstrate the basic idea: store objects by the type they provide.
    private final Map<Class<?>, Object> beans = new HashMap<>();

    public SimpleContainer() {
        // These are configuration decisions, moved outside OrderService.
        register(NotificationService.class, new EmailNotification());
        register(OrderService.class, new OrderService(get(NotificationService.class)));
    }

    public <T> void register(Class<T> type, T instance) {
        // Example: register(NotificationService.class, emailObject).
        beans.put(type, instance);
    }

    public <T> T get(Class<T> type) {
        Object bean = beans.get(type);
        if (bean == null) {
            // A missing dependency should be reported instead of failing
            // later with a confusing NullPointerException.
            throw new IllegalArgumentException("No bean registered for " + type.getSimpleName());
        }
        // Class.cast keeps the returned object type-safe for the caller.
        return type.cast(bean);
    }
}
