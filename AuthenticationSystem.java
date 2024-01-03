package TypingTestVer11;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AuthenticationSystem {
    private static final String USER_FILE_PATH = "/Users/vatteyou/TypingTest/TypingTestVer8/Users.txt";
    private Map<String, User> loginInfo;
    private User currentUser; // Add this field to store the current user

    public AuthenticationSystem() { 
        loginInfo = new HashMap<>();
        loadUsers();
    }

    private void loadUsers() {
        Path filePath = Paths.get(USER_FILE_PATH);

        try (Scanner fileScanner = new Scanner(filePath.toFile())) {
            while (fileScanner.hasNextLine()) {
                String[] userInfo = fileScanner.nextLine().split(":");
                String username = userInfo[0];
                String password = userInfo[1];
                int role = Integer.parseInt(userInfo[2]);

                User user;
                if (role == 1) {
                    user = new Admin(username, password);
                } else {
                    user = new User(username, password);
                }

                loginInfo.put(username, user);
            }
        } catch (IOException e) {
            System.err.println("Error loading users from file: " + e.getMessage());
        }
    }

    private void saveUsers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE_PATH))) {
            for (User user : loginInfo.values()) {
                int role = (user instanceof Admin) ? 1 : 0;
                writer.write(user.getUserInfo() + ":" + role);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving users to file: " + e.getMessage());
        }
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    private void setCurrentUser(User user) {
        currentUser = user;
    }

    public void logout() {
        currentUser = null;
    }

    public void register(int roleChoice, String username, String password) {
        if (roleChoice != 1 && roleChoice != 2) {
            System.err.println("Invalid input!");
            return;
        }

        // Check if username or password is empty
        if (username.isEmpty() || password.isEmpty()) {
            System.err.println("Error: Empty username or password. Registration failed.");
            return;
        }

        if (loginInfo.containsKey(username)) {
            System.err.println("Error: Username already exists. Registration failed.");
            return; // Username already exists
        }

        User newUser;
        if (roleChoice == 2) {
            newUser = new Admin(username, password);
        } else {
            newUser = new User(username, password);
        }

        loginInfo.put(username, newUser);

        saveUsers();
        System.out.println("Registration successful for username: " + username);
    }

    public boolean authenticate(String username, String password) {
        User authenticatedUser = loginInfo.get(username);

        if (authenticatedUser != null && authenticatedUser.authenticate(password)) {
            System.out.println("Authentication successful.");
            return true;
        } else {
            System.out.println("Authentication failed. Invalid username or password.");
            return false;
        }
    }

    public int login(String username, String password) {
        User authenticatedUser = loginInfo.get(username);

        if (authenticatedUser != null && authenticatedUser.authenticate(password)) {
            setCurrentUser(authenticatedUser);

            if (authenticatedUser instanceof Admin) {
                System.out.println("Admin logged in!");
                return 1;
            } else {
                System.out.println("Regular user logged in!");
                return 0;
            }
        } else {
            System.out.println("Authentication failed. Invalid username or password.");
            return 2;
        }
    }
}
