# Dependency Injection and Inversion of Control

This project teaches **Dependency Injection (DI)** and **Inversion of Control
(IoC)** from the beginning. It does not start with Spring annotations. First,
we build the problem with ordinary Java, and then we improve the design step
by step.

The recommended learning order is:

```text
src/main/java/org/example/
├── old/                       # 1. A normal first solution
├── coupling/                  # 2. Problems in that solution
│   ├── notification/
│   ├── payment/
│   └── testing/
├── di/                        # 3. Supplying dependencies from outside
│   ├── constructor/
│   └── setter/
└── ioc/                       # 4. A small object-creation container
```

Every folder contains a small runnable demo. Read the explanation first, then
run the related program and compare the code with the output.

---

## 1. Very small Java foundation

Before discussing DI, understand three words:

### Class

A class is a blueprint. For example, `EmailSender` describes an object that
can send an email.

```java
public class EmailSender {
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }
}
```

### Object

An object is a real item created from a class:

```java
EmailSender sender = new EmailSender();
```

The `new` keyword creates the object. You can think of a class as a recipe and
an object as the meal prepared from that recipe.

### Method

A method is an action an object can perform. In the example above, `send` is
the action performed by `EmailSender`.

---

## 2. What is a dependency?

Suppose `OrderService` must send a confirmation after an order is placed.
`OrderService` cannot send an email by itself, so it needs an `EmailSender`.

That means:

```text
OrderService depends on EmailSender
```

`EmailSender` is a **dependency** because `OrderService` needs it to complete
its work.

An everyday analogy:

> A driver depends on a car to travel. The driver is responsible for driving,
> but the driver should not need to manufacture a car before every trip.

In software, the order service should concentrate on order behavior. It should
not also be responsible for manufacturing every object it needs.

---

## 3. The first solution: `old`

Open these files:

```text
old/EmailSender.java
old/OrderService.java
old/OldStyleDemo.java
```

### `EmailSender.java`

This class has one responsibility: send an email.

```java
public class EmailSender {
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }
}
```

### `OrderService.java`

```java
public class OrderService {
    public void placeOrder() {
        System.out.println("Order placed.");
        EmailSender emailSender = new EmailSender();
        emailSender.send("Thank you for your order.");
    }
}
```

Read this code in order:

1. The method prints that the order was placed.
2. It creates an `EmailSender`.
3. It uses that sender to send a message.

This program works. There is nothing technically wrong with using `new`.
However, `OrderService` now has two responsibilities:

1. Place an order.
2. Decide how to create and use the notification sender.

This is acceptable in a tiny program. As the application grows, this design
creates **coupling**.

Run it:

```bash
java -cp target/classes org.example.old.OldStyleDemo
```

---

## 4. What is coupling?

**Coupling is the level of dependency between two parts of a program.**

If class A knows the exact class, construction details, and internal choices
of class B, they are strongly or tightly coupled.

If class A knows only the small capability it needs from B, they are loosely
coupled.

### A simple analogy

Imagine a wall-mounted lamp:

- **Tight coupling:** The lamp is permanently wired to one exact battery.
  Replacing the battery requires opening the lamp.
- **Loose coupling:** The lamp has a standard socket. Any compatible battery
  can be plugged in without changing the lamp.

The lamp needs power, but it should not care which compatible battery provides
that power. Likewise, `OrderService` needs notification behavior, but it
should not care whether email, SMS, or a test object provides it.

### Why tight coupling causes problems

Tight coupling usually makes code:

- **Harder to change:** one implementation change requires editing many classes.
- **Harder to reuse:** a class can work only with the object it creates.
- **Harder to test:** real databases, networks, or payment providers are used
  during tests.
- **Harder to understand:** business logic and configuration are mixed together.
- **Harder to extend:** adding a new implementation creates more conditions and
  `new` statements.

The next three folders intentionally demonstrate these problems.

---

## 5. Coupling problem A: notification channels

Open:

```text
coupling/notification/
```

The folder contains email and SMS notification classes, plus this service:

```java
public class OrderService {
    public void placeOrder(String channel) {
        System.out.println("Order placed.");

        if ("sms".equalsIgnoreCase(channel)) {
            new SmsNotification().send("Your order is on its way.");
        } else {
            new EmailNotification().send("Thank you for your order.");
        }
    }
}
```

The service is tightly coupled because it knows:

- The concrete class `SmsNotification`.
- The concrete class `EmailNotification`.
- How to create both classes.
- The rule that decides which class to use.

Imagine adding WhatsApp:

```java
if ("whatsapp".equalsIgnoreCase(channel)) {
    new WhatsAppNotification().send(message);
}
```

Now the order business class must be edited again. If ten services contain
similar logic, the change must be repeated ten times.

The deeper issue is that the service depends on **implementations** rather
than a common **capability**.

Run it:

```bash
java -cp target/classes org.example.coupling.notification.NotificationCouplingDemo
```

---

## 6. Coupling problem B: payment provider

Open:

```text
coupling/payment/
```

The checkout code is:

```java
public class CheckoutService {
    public void checkout(double amount) {
        StripePayment stripePayment = new StripePayment();
        stripePayment.pay(amount);
    }
}
```

The checkout operation is business logic. Stripe is a configuration choice.
But the class combines both:

```text
checkout business logic + Stripe object creation
```

If the application moves from Stripe to PayPal, the class must be edited. A
better design would allow `CheckoutService` to use any object that provides a
`pay` capability.

This is the same problem as the notification example, just with a different
business domain.

Run it:

```bash
java -cp target/classes org.example.coupling.payment.PaymentCouplingDemo
```

---

## 7. Coupling problem C: difficult testing

Open:

```text
coupling/testing/
```

The validator creates a real inventory object:

```java
public class OrderValidator {
    public boolean isValid(String product) {
        RealInventory inventory = new RealInventory();
        return inventory.hasStock(product);
    }
}
```

Imagine `RealInventory.hasStock` calls a database or remote service. A test
for `OrderValidator` would then need:

- A running database.
- Network access.
- Test inventory data.
- More time.
- More possible failures unrelated to validation logic.

For a unit test, we would prefer a tiny fake object:

```text
FakeInventory always says that "Laptop" is in stock.
```

But `OrderValidator` creates `RealInventory` internally, so the test cannot
replace it. This is one of the most important practical reasons for DI:
**injected dependencies can be replaced with fakes or mocks.**

Run it:

```bash
java -cp target/classes org.example.coupling.testing.TestingCouplingDemo
```

---

## 8. The design improvement

The business class should answer:

```text
What do I need to do?
```

It should not answer:

```text
Which concrete object should I create?
How should that object be configured?
How can I replace that object during a test?
```

Move object selection and object creation outside the business class.

This produces two separate responsibilities:

```text
Business class: performs business work
Application configuration: chooses and supplies implementations
```

That separation is the foundation of Dependency Injection.

---

## 9. What is Dependency Injection?

**Dependency Injection means giving an object the dependencies it needs from
outside instead of making it create those dependencies itself.**

There are three common forms:

1. Constructor injection.
2. Setter injection.
3. Field injection, commonly seen with framework annotations.

This project demonstrates the first two. Constructor injection is usually the
best default because required dependencies are visible and cannot be forgotten
after construction.

---

## 10. Constructor injection

Open:

```text
di/constructor/
```

### The interface

```java
public interface NotificationService {
    void send(String message);
}
```

An interface is a contract. It says:

> Any class that implements me must provide a `send` method.

It does not say whether the message is sent by email, SMS, or a fake test
object.

### The implementation

```java
public class EmailNotification implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}
```

`EmailNotification` fulfills the `NotificationService` contract.

### The dependent class

```java
public class OrderService {
    private final NotificationService notificationService;

    public OrderService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void placeOrder() {
        System.out.println("Order placed.");
        notificationService.send("Thank you for your order.");
    }
}
```

Important details:

1. `OrderService` depends on the interface, not directly on email.
2. The constructor receives the dependency.
3. `final` means the dependency is assigned once.
4. `OrderService` does not use `new EmailNotification()`.
5. The business method only uses the capability it needs: `send`.

The constructor is like giving a worker the required tool before the worker
starts. The worker does not need to visit a shop during every task.

### The wiring code

```java
NotificationService notification = new EmailNotification();
OrderService orderService = new OrderService(notification);
orderService.placeOrder();
```

Read it as:

1. Choose email as the implementation.
2. Give that implementation to `OrderService`.
3. Ask the order service to place the order.

To use another implementation, change the wiring code, not `OrderService`.

Run it:

```bash
java -cp target/classes org.example.di.constructor.ConstructorInjectionDemo
```

### Why constructor injection is strong

This is not allowed to be incomplete:

```java
new OrderService(); // Does not compile: no dependency was supplied
```

The object must receive its required dependency during construction. This
usually makes the class easier to understand and safer to use.

---

## 11. Setter injection

Open:

```text
di/setter/
```

The service uses a setter:

```java
OrderService orderService = new OrderService();
orderService.setNotificationService(new SmsNotification());
orderService.placeOrder();
```

The dependency is supplied after the object is created.

The setter implementation is:

```java
public void setNotificationService(NotificationService notificationService) {
    this.notificationService = notificationService;
}
```

This can be useful when a dependency is optional or can be changed later.
However, it also means that an incomplete `OrderService` can exist temporarily.

That is why `placeOrder` checks for a missing dependency:

```java
if (notificationService == null) {
    throw new IllegalStateException("Configure a notification service first.");
}
```

This is better than allowing a confusing `NullPointerException` later.

Run it:

```bash
java -cp target/classes org.example.di.setter.SetterInjectionDemo
```

### Constructor injection versus setter injection

| Constructor injection | Setter injection |
|---|---|
| Dependency is supplied during construction | Dependency is supplied afterward |
| Best for required dependencies | Useful for optional or replaceable dependencies |
| Object is valid immediately | Object may be incomplete temporarily |
| Missing dependency is prevented by the constructor | Missing dependency must be validated |

---

## 12. What is Inversion of Control?

Normally, application code controls object creation:

```java
EmailNotification email = new EmailNotification();
OrderService orders = new OrderService(email);
```

The application decides:

- Which objects to create.
- In which order to create them.
- Which object should be passed to which constructor.

**Inversion of Control means moving this control away from the business class
and giving it to another component, usually a framework or container.**

The word “inversion” means that control has changed direction:

```text
Without IoC:
    application code creates and wires services

With IoC:
    a container creates and wires services
    application code asks the container for ready objects
```

An analogy:

> In a restaurant, the customer does not buy ingredients, choose the kitchen
> tools, and wire the oven. The kitchen handles preparation and gives the
> customer the finished meal. An IoC container handles object preparation and
> gives the application ready-to-use objects.

---

## 13. The small IoC container

Open:

```text
ioc/
```

### `SimpleContainer`

```java
public class SimpleContainer {
    private final Map<Class<?>, Object> beans = new HashMap<>();
```

The map is a small registry. It stores objects by the type through which they
will be requested.

```java
register(NotificationService.class, new EmailNotification());
```

This means:

```text
When someone asks for NotificationService, use this EmailNotification object.
```

Then the container creates the order service:

```java
register(OrderService.class,
         new OrderService(get(NotificationService.class)));
```

Read the inner part first:

1. `get(NotificationService.class)` retrieves the email notification.
2. That object is passed to the `OrderService` constructor.
3. The completed `OrderService` is registered.

The container has performed the wiring that the application used to perform.

### Retrieving an object

```java
OrderService orderService = container.get(OrderService.class);
orderService.placeOrder();
```

The caller receives a ready-to-use service. It does not need to know how the
service's dependency was created.

`Class.cast` checks that the stored object has the requested type. If a bean
was not registered, the container throws a clear exception instead of silently
returning `null`.

### How Spring relates to this

This project uses a tiny hand-written container so the idea remains visible.
Spring's `ApplicationContext` does much more:

- Finds classes configured as beans.
- Creates objects.
- Resolves dependencies.
- Calls constructors or setters.
- Manages object lifetime and scopes.
- Provides configuration, events, and many other services.

The basic idea is still the same: Spring controls object creation and injects
dependencies into application classes.

Run it:

```bash
java -cp target/classes org.example.ioc.IoCDemo
```

---

## 14. DI and IoC are related but not identical

These terms are often used together, but they are not synonyms:

```text
Dependency Injection = the technique of supplying dependencies
Inversion of Control = the broader principle of moving control elsewhere
```

Constructor injection is DI even when you wire objects manually:

```java
new OrderService(new EmailNotification());
```

IoC appears when a container takes responsibility for creating and wiring
those objects:

```java
container.get(OrderService.class);
```

Spring uses IoC as the overall principle and DI as one of its main techniques.

---

## 15. Compile and run all examples

From the `SpringCore` directory:

```bash
mvn clean compile
```

Run the examples in this order:

```bash
java -cp target/classes org.example.old.OldStyleDemo
java -cp target/classes org.example.coupling.notification.NotificationCouplingDemo
java -cp target/classes org.example.coupling.payment.PaymentCouplingDemo
java -cp target/classes org.example.coupling.testing.TestingCouplingDemo
java -cp target/classes org.example.di.constructor.ConstructorInjectionDemo
java -cp target/classes org.example.di.setter.SetterInjectionDemo
java -cp target/classes org.example.ioc.IoCDemo
```

---

## 16. Practice exercises

Try these in order:

1. Add `PushNotification` to `di/constructor`.
2. Use `PushNotification` without changing `OrderService`.
3. Add a `FakeNotification` that stores the message instead of printing it.
4. Create a `PaymentGateway` interface and refactor `CheckoutService` to
   receive it through its constructor.
5. Create a fake inventory implementation and inject it into a new
   `OrderValidator`.
6. Change the registration in `SimpleContainer` from email to SMS without
   changing `IoCDemo` or the IoC `OrderService`.

If you can replace an implementation without changing the business class,
you are using the main benefit of loose coupling and Dependency Injection.

---

## Final summary

1. A **dependency** is an object another object needs.
2. **Coupling** describes how strongly two parts of a program depend on each
   other.
3. Tight coupling makes changing, testing, and extending code difficult.
4. **Dependency Injection** supplies dependencies from outside the dependent
   class.
5. Constructor injection is normally best for required dependencies.
6. Setter injection can be useful for optional or changeable dependencies.
7. **Inversion of Control** moves object creation and wiring to a container or
   framework.
8. Spring's IoC container is a powerful version of the small container shown
   in this project.
