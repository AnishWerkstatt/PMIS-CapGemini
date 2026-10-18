package learning.junit5.lifecycle;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShoppingCartTest {
    private ShoppingCart cart;

    @BeforeAll
    static void beforeAllTests() {
        System.out.println("Starting ShoppingCart tests");
    }

    @BeforeEach
    void createFreshCart() {
        cart = new ShoppingCart();
    }

    @AfterEach
    void clearCart() {
        cart.clear();
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("Finished ShoppingCart tests");
    }

    @Test
    void newCartHasNoItems() {
        assertEquals(0, cart.itemCount());
    }

    @Test
    void addingAnItemIncreasesTheCount() {
        cart.add("Notebook");

        assertEquals(1, cart.itemCount());
    }
}
