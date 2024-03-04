/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user_manager;

/**
 *
 * @author admin
 */
public class User {
    private String username;
    private String email;
    private String password;

    // Constructors, getters, setters, and other necessary methods
    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", email=" + email + ", password=" + password + '}';
    }

    // Example method for updating user information
    public void updateUserInfo(String newEmail) {
        this.email = newEmail;
        // Additional logic for updating other information
    }
}
