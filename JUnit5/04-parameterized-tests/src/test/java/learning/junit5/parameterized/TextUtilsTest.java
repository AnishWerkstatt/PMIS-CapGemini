package learning.junit5.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TextUtilsTest {
    private final TextUtils textUtils = new TextUtils();

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    @NullSource
    void recognizesBlankText(String input) {
        assertTrue(textUtils.isBlank(input));
    }

    @ParameterizedTest
    @CsvSource({"A, 3, AAA", "go, 2, gogo", "Java, 1, Java"})
    void repeatsText(String text, int count, String expected) {
        assertEquals(expected, textUtils.repeat(text, count));
    }
}
