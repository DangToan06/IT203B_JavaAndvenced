package kha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserValidatorTest {
    UserValidator userValidator = new UserValidator();

    @Test
    @DisplayName("TC01")
    void validUsername() {
        String username = "sonbui";
        boolean result = userValidator.isValidUsername(username);
        assertTrue(result);
    }

    @Test
    @DisplayName("TC02")
    void validUsernameTooShort() {
        String username = "son";
        boolean result = userValidator.isValidUsername(username);
        assertFalse(result);
    }

    @Test
    @DisplayName("TC03")
    void validUsernameHasSpace() {
        String username = "son bui";
        boolean result = userValidator.isValidUsername(username);
        assertFalse(result);
    }
}
