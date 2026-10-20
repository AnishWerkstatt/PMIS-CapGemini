package learning.junit5.first;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreetingTest {
    @Test
    void saysHelloToThePerson() {
        Greeting greeting = new Greeting();

        String result = greeting.sayHello("Ada");

        assertEquals("Hello, Ada!", result);
        //Assertions.assertEquals("Hello, Ada!", result); -- Without a Static Import.
        

    }
}
