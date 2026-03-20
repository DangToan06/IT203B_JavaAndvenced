package org.example.tongHop;

public interface IUserAccount {
    String getRole();

    default boolean checkAccess() {
        return getRole().equals("ADMIN");
    }

    static boolean standardLength(String username){
        if(username.length()<5) {
            return false;
        }
        return true;
    }
}
