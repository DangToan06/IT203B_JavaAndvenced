import java.util.List;
import java.util.Optional;

public class UserRepository {
    private final List<User> users = List.of(
            new User("alice", "alice@gmail.com", Status.ACTIVE),
            new User("bob", "bob@yahoo.com", Status.INACTIVE),
            new User("charlie", "charlie@gmail.com", Status.ACTIVE)
    );

    public Optional<User> findUserByName(String name) {
        return users.stream()
                .filter(user -> user.username().equalsIgnoreCase(name))
                .findFirst();
    }
}
