import java.util.List;

public class Bai02 {
    public static void streamFilter(){
        List<User> users = List.of(
                new User("alice", "alice@gmail.com", Status.ACTIVE),
                new User("bob", "bob@yahoo.com", Status.INACTIVE),
                new User("charlie", "charlie@gmail.com", Status.ACTIVE),
                new User("dave", "dave@outlook.com", Status.ACTIVE)
        );

        System.out.println("--- Các User sử dụng Gmail ---");

        users.stream()
                .filter(user -> user.email().endsWith("@gmail.com"))
                .forEach(user -> System.out.println(user.email()));
    }
}