
void main() {
//    Bai01
//    User u1 = new User("user1", "user1@gmail.com", Status.ACTIVE);
//    User u2 = new User("user2", "user2@gmail.com", Status.INACTIVE);
//    User u3 = new User("user3", "user3@gmail.com", Status.ACTIVE);
//
//    List<User> users = List.of(u1, u2, u3);
//
//    System.out.println("--- Danh sách người dùng ---");
//    users.forEach(user -> System.out.println(user));

//    Bai02
//    Bai02.streamFilter();

//    Bai03
//    UserRepository userRepository = new UserRepository();
//
//    Optional<User> foundUser = userRepository.findUserByName("alice");
//    foundUser.ifPresentOrElse(
//            user -> System.out.println("Welcome " + user.username()),
//            () -> System.out.println("Guest login")
//    );


//    Bai04
//    List<User> users = List.of(
//            new User("Toan", "Toan@gmail.com", Status.ACTIVE),
//            new User("Quang", "Quang@yahoo.com", Status.INACTIVE),
//            new User("Duong", "Duong@gmail.com", Status.ACTIVE),
//            new User("Duong", "Duong@gmail.com", Status.ACTIVE),
//            new User("Huy", "Huy@yahoo.com", Status.ACTIVE)
//    );
//
//    Collection<User> distinctUsers = users.stream()
//            .collect(Collectors.toMap(
//                    User::username,
//                    user -> user,
//                    (existing, replacement) -> existing
//            ))
//            .values();
//
//    System.out.println("--- Danh sách sau khi loại bỏ trùng username (toMap) ---");
//    distinctUsers.forEach(System.out::println);


//    Bai05
//    List<User> users = List.of(
//            new User("Toan", "Toan@gmail.com", Status.ACTIVE),
//            new User("Quang", "Quang@yahoo.com", Status.INACTIVE),
//            new User("Duong", "Duong@gmail.com", Status.ACTIVE),
//            new User("Trang", "Trang@gmail.com", Status.ACTIVE),
//            new User("Huy", "Huy@yahoo.com", Status.ACTIVE)
//    );
//    System.out.println("--- Top 3 người dùng có username dài nhất ---");
//
//    users.stream()
//            .sorted(Comparator.comparingInt((User u) -> u.username().length()).reversed())
//            .limit(3)
//            .forEach(user -> System.out.println(user.username() + " (" + user.username().length() + " ký tự)"));

//    Bai06
//    List<Post> posts = List.of(
//            new Post("Java Tutorial", List.of("java", "backend")),
//            new Post("Python for Data", List.of("python", "data")),
//            new Post("Frontend Basics", List.of("html", "css"))
//    );
//
//    List<String> allTags = posts.stream()
//            .flatMap(post -> post.tags().stream())
//            .collect(Collectors.toList());
//
//    System.out.println("--- Danh sách Tags đã làm phẳng ---");
//    System.out.println(allTags);
}
