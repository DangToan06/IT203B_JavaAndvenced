package xuatsac6;

import java.time.LocalDate;
import java.util.List;

public class UserService {

    public User updateProfile(User existingUser, UserProfile newProfile, List<User> allUsers) {

        // kiểm tra ngày sinh tương lai
        if (newProfile.getBirthDate().isAfter(LocalDate.now())) {
            return null;
        }

        String newEmail = newProfile.getEmail();

        // kiểm tra email trùng
        if (!newEmail.equals(existingUser.getEmail())) {
            for (User user : allUsers) {
                if (user.getEmail().equals(newEmail)) {
                    return null;
                }
            }
        }

        // cập nhật thông tin
        existingUser.setEmail(newEmail);
        existingUser.setBirthDate(newProfile.getBirthDate());
        existingUser.setName(newProfile.getName());

        return existingUser;
    }
}