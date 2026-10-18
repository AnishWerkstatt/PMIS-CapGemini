package learning.junit5.nested;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Username validation")
class UserValidatorTest {
    private final UserValidator validator = new UserValidator();

    @Nested
    @DisplayName("when the username is valid")
    class ValidUsername {
        @Test
        @DisplayName("accepts letters and numbers")
        void acceptsLettersAndNumbers() {
            assertTrue(validator.isValidUsername("Ada123"));
        }
    }

    @Nested
    @DisplayName("when the username is invalid")
    class InvalidUsername {
        @Test
        void rejectsShortNames() {
            assertFalse(validator.isValidUsername("ab"));
        }

        @Test
        void rejectsSpecialCharacters() {
            assertFalse(validator.isValidUsername("ada!"));
        }
    }
}
