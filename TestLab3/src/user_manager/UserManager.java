/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user_manager;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author admin
 */
public class UserManager {

    private Map<String, User> users;

    public UserManager() {
        this.users = new HashMap<>();
    }

    public boolean registerUser(String username, String email, String password) {
        // Check if the username or email already exists
        if (users.containsKey(username) || emailExists(email)) {
            throw new IllegalArgumentException("Username or email already exists");
        }
        if (username == null || username.length() <= 0 || username.length() > 20) {
            throw new IllegalArgumentException("Username must be > 0 && < 20");
        }
        if (email == null || !email.contains("@") || email.length() < 0 || email.length() > 40) {
            throw new IllegalArgumentException("Username must be > 0 && < 50 && contain @");
        }
        if (password == null || password.length() <= 0 || password.length() >= 40) {
            throw new IllegalArgumentException("password must be > 0 && < 50");
        }
        User newUser = new User(username, email, password);
        users.put(username, newUser);
        users.put(email, newUser);
        return true;
    }

    public boolean loginUser(String username, String password) {
        if (!users.containsKey(username)) {
            return false;
        }

        return users.get(username).getPassword().equals(password);
    }

    public boolean updateUserEmail(String username, String newEmail) {
        if (!users.containsKey(username)) {
            throw new IllegalArgumentException("User not found");
        }

        users.get(username).updateUserInfo(newEmail);
        return true;
    }

    public boolean deleteUser(String username) {
        // Check if the username exists
        if (!users.containsKey(username)) {
            throw new IllegalArgumentException("User not found");
        }
        if (username == null || username.length() <= 0 || username.length() > 20) {
            throw new IllegalArgumentException("Username must be > 0 && < 20");
        }
        users.remove(username);
        return true;
    }

    private boolean emailExists(String email) {
        // Check if the email exists in the user map
        return users.values().stream().anyMatch(user -> user.getEmail().equals(email));
    }

    public boolean updatePassword(String username, String oldPassword, String newPassword) {
        // Check if the username exists
        if (!users.containsKey(username)) {
            throw new IllegalArgumentException("User not found");
        }

        // Check if the old password is correct
        if (!users.get(username).getPassword().equals(oldPassword)) {
            throw new IllegalArgumentException("Incorrect old password");
        }

        if (newPassword == null || newPassword.length() <= 0 || newPassword.length() >= 40 || newPassword.equals(oldPassword)
                || !newPassword.matches(".*\\d.*")) {
            throw new IllegalArgumentException("password must be > 0 && < 50 && not equal oldpass || not contain number");
        }
        // Update the user's password
        users.get(username).setPassword(newPassword);
        return true;
    }
}
