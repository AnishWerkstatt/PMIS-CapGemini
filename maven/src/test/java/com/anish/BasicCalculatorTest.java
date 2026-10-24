package com.anish;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BasicCalculatorTest {

    @Test
    public void shouldAddTwoNumbers() {
        assertEquals(13, BasicCalculator.add(8, 5));
    }

    @Test
    public void shouldMultiplyTwoNumbers() {
        assertEquals(40, BasicCalculator.multiply(8, 5));
    }
}
