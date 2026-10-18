package learning.junit5.assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    void addsTwoNumbers() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    void reportsSeveralPropertiesTogether() {
        int result = calculator.add(2, 3);

        assertAll(
                () -> assertEquals(5, result),
                () -> assertTrue(result > 0),
                () -> assertEquals(0, calculator.add(-2, 2))
        );
    }

    @Test
    void rejectsDivisionByZero() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.divide(10, 0)
        );

        assertEquals("Divisor cannot be zero", exception.getMessage());
    }
}
