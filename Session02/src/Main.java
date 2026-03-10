
void main() {
//    Bai02.kiemTraMatKhau();

//    Bai04
//    List<User> users = Arrays.asList(
//            new User("Alice"),
//            new User("Bob"),
//            new User("Charlie")
//    );
//
//    System.out.println("Danh sachs userName");
//
//    users.stream()
//            .map(User::getUsername)
//            .forEach(System.out::println);
//
//    System.out.println("Tao user moi");
//
//    Supplier<User> userSupplier = User::new;
//    User newUser = userSupplier.get();
//    System.out.println("Tên user mới: " + newUser.getUsername());

//    Bai06
    User myUser = new User("nguyen van a");

    UserProcessor userProcessor = UserUtils::convertToUpperCase;

    String username = userProcessor.process(myUser);

    System.out.println(username);
}
