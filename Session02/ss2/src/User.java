public class User {
    private String username;

    public User() {
        this.username = "Default User";
    }

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}