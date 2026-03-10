@FunctionalInterface
public interface Authenticatable {

    String getPassword();

    default boolean isAuthenticated() {
        String password = getPassword();
        return password != null && !password.trim().isEmpty();
    }

    static String encrypt(String rawPassword) {
        if (rawPassword == null) return null;
        return "ENCRYPTED_" + new StringBuilder(rawPassword).reverse().toString();
    }
}