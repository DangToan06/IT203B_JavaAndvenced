package org.example.tongHop;

import javax.management.relation.Role;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class UserManagement {
    Supplier<User> createUser = User::new;

    Predicate<User> checkRole = IUserAccount::checkAccess;

    Function<User, String> emailUser = User::getEmail;
}
