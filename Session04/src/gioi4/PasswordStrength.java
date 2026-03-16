package gioi4;

public class PasswordStrength {
    public String evaluatePasswordStrength(String password) {
        if (password.length() < 8 || password.matches("[A-Z0-9]+")||password.matches("[a-z]+")) {
            return "Weak";
        }
        if (password.matches("^[A-Za-z0-9]")) {
            return "Medium";
        }
        return "Good";
    }
}
