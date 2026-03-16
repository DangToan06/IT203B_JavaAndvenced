package kha1;

class UserValidator {
    public boolean isValidUsername(String username) {
        if (username.isBlank()) {
            return false;
        }
        if (username.length() < 6 || username.length() > 30) {
            return false;
        }
        if (username.contains(" ")) {
            return false;
        }
        return true;
    }
}
