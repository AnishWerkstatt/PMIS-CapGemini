package learning.junit5.advanced;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.DynamicTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("advanced")
class NumberToolsTest {
    private final NumberTools numberTools = new NumberTools();

    @RepeatedTest(3)
    void evenCheckIsStable() {
        assertTrue(numberTools.isEven(8));
    }

    @TestFactory
    Stream<DynamicTest> doublesSeveralNumbers() {
        return Stream.of(1, 2, 5)
                .map(number -> DynamicTest.dynamicTest(
                        "doubles " + number,
                        () -> assertEquals(number * 2, numberTools.doubleValue(number))
                ));
    }

    @org.junit.jupiter.api.Test
    @Timeout(1)
    void completesQuickly() {
        assertEquals(20, numberTools.doubleValue(10));
    }
}
