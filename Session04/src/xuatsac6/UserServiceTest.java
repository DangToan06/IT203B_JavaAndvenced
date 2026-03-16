package xuatsac6;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    UserService service = new UserService();

    @Test
    void updateProfile_success_whenEmailAndBirthDateValid() {

        User user = new User("a@gmail.com", LocalDate.of(2000, 1, 1), "A");

        UserProfile profile =
                new UserProfile("b@gmail.com", LocalDate.of(1999, 1, 1), "B");

        List<User> users = new ArrayList<>();

        User result = service.updateProfile(user, profile, users);

        assertNotNull(result);
    }

    @Test
    void updateProfile_fail_whenBirthDateInFuture() {

        User user = new User("a@gmail.com", LocalDate.of(2000, 1, 1), "A");

        UserProfile profile =
                new UserProfile("b@gmail.com", LocalDate.now().plusDays(1), "B");

        List<User> users = new ArrayList<>();

        User result = service.updateProfile(user, profile, users);

        assertNull(result);
    }

    @Test
    void updateProfile_fail_whenEmailDuplicate() {

        User user = new User("a@gmail.com", LocalDate.of(2000, 1, 1), "A");

        User other = new User("b@gmail.com", LocalDate.of(1990, 1, 1), "B");

        List<User> users = new ArrayList<>();
        users.add(other);

        UserProfile profile =
                new UserProfile("b@gmail.com", LocalDate.of(1999, 1, 1), "C");

        User result = service.updateProfile(user, profile, users);

        assertNull(result);
    }

    @Test
    void updateProfile_success_whenEmailSameAsCurrent() {

        User user = new User("a@gmail.com", LocalDate.of(2000, 1, 1), "A");

        UserProfile profile =
                new UserProfile("a@gmail.com", LocalDate.of(1998, 1, 1), "NewName");

        List<User> users = new ArrayList<>();

        User result = service.updateProfile(user, profile, users);

        assertNotNull(result);
    }

    @Test
    void updateProfile_success_whenUserListEmpty() {

        User user = new User("a@gmail.com", LocalDate.of(2000, 1, 1), "A");

        UserProfile profile =
                new UserProfile("new@gmail.com", LocalDate.of(1999, 1, 1), "B");

        List<User> users = new ArrayList<>();

        User result = service.updateProfile(user, profile, users);

        assertNotNull(result);
    }

    @Test
    void updateProfile_fail_whenDuplicateEmailAndFutureBirthDate() {

        User user = new User("a@gmail.com", LocalDate.of(2000, 1, 1), "A");

        User other = new User("b@gmail.com", LocalDate.of(1990, 1, 1), "B");

        List<User> users = new ArrayList<>();
        users.add(other);

        UserProfile profile =
                new UserProfile("b@gmail.com", LocalDate.now().plusDays(5), "Test");

        User result = service.updateProfile(user, profile, users);

        assertNull(result);
    }
}