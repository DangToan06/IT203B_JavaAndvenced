package org.example.tongHop;

public class User implements IUserAccount{

    private String username;
    private String email;
    private String role;
    private String status;

    public User() {
    }

    public User(String username, String email, String role, String status) {
        this.username = username;
        this.email = email;
        this.role = role;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public String toString(){
        return    "\n--------------------"
                + "\nThông tin user"
                + "\nUsername: " + getUsername()
                + "\nEmail: " + getEmail()
                + "\nRole: " + getRole()
                + "\nStatus: " + getStatus()
                + "\n--------------------";
    }
}
