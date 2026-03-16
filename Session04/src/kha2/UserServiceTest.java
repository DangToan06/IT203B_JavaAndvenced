package kha2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserServiceTest {
    UserService userService = new UserService();

    @Test
    @DisplayName("Tuoi hop le")
    void ageAcpect() {
        int age = 18;
        boolean result = userService.checkRegistrationAge(age);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Tuoi khong hop le")
    void ageLessThanAgeAcpect() {
        int age = 17;
        boolean result = userService.checkRegistrationAge(age);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Tuoi be hon 0")
    void ageLessThanZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.checkRegistrationAge(-1);
        });
    }
}
