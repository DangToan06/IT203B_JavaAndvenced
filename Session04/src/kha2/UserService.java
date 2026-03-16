package kha2;

public class UserService {
    public boolean checkRegistrationAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Tuoi khong hop le");
        }
        if (age < 18) {
            return false;
        }
        return true;
    }
}
