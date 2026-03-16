package gioi4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class PasswordStrengthTest {
    PasswordStrength passwordStrength = new PasswordStrength();

    @Test
    void testPassword() {
        String password = "ABC12345";
        Assertions.assertEquals("Weak", passwordStrength.evaluatePasswordStrength(password));
        password = "password";
        Assertions.assertEquals("Weak", passwordStrength.evaluatePasswordStrength(password));
        password = "Ab1!";
        Assertions.assertEquals("Weak", passwordStrength.evaluatePasswordStrength(password));
        password = "Abc123!@";
        Assertions.assertEquals("Good", passwordStrength.evaluatePasswordStrength(password));
    }
}
