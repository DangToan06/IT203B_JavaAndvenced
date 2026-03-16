package xuatsac5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccessControlTest {
    @Test
    public void testAdminDeleteUser() {
        AccessControlService service = new AccessControlService();
        User user = new User(Role.ADMIN);

        boolean result = service.canPerformAction(user, Action.DELETE_USER);

        assertTrue(result);
    }

    @Test
    public void testAdminLockUser() {
        AccessControlService service = new AccessControlService();
        User user = new User(Role.ADMIN);

        boolean result = service.canPerformAction(user, Action.LOCK_USER);

        assertTrue(result);
    }

    @Test
    public void testAdminViewProfile() {
        AccessControlService service = new AccessControlService();
        User user = new User(Role.ADMIN);

        boolean result = service.canPerformAction(user, Action.VIEW_PROFILE);

        assertTrue(result);
    }

    @Test
    public void testModeratorDeleteUser() {
        AccessControlService service = new AccessControlService();
        User user = new User(Role.MODERATOR);

        boolean result = service.canPerformAction(user, Action.DELETE_USER);

        assertFalse(result);
    }

    @Test
    public void testModeratorLockUser() {
        AccessControlService service = new AccessControlService();
        User user = new User(Role.MODERATOR);

        boolean result = service.canPerformAction(user, Action.LOCK_USER);

        assertTrue(result);
    }

    @Test
    public void testModeratorViewProfile() {
        AccessControlService service = new AccessControlService();
        User user = new User(Role.MODERATOR);

        boolean result = service.canPerformAction(user, Action.VIEW_PROFILE);

        assertTrue(result);
    }

    @Test
    public void testUserDeleteUser() {
        AccessControlService service = new AccessControlService();
        User user = new User(Role.USER);

        boolean result = service.canPerformAction(user, Action.DELETE_USER);

        assertFalse(result);
    }

    @Test
    public void testUserLockUser() {
        AccessControlService service = new AccessControlService();
        User user = new User(Role.USER);

        boolean result = service.canPerformAction(user, Action.LOCK_USER);

        assertFalse(result);
    }

    @Test
    public void testUserViewProfile() {
        AccessControlService service = new AccessControlService();
        User user = new User(Role.USER);

        boolean result = service.canPerformAction(user, Action.VIEW_PROFILE);

        assertTrue(result);
    }
}