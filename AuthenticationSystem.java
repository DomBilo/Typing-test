package TypingTestFinalVer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AuthenticationSystem {
    // File path to store user information
    private static final String USER_FILE_PATH = "/Users/vatteyou/TypingTest/TypingTestFinalVer/UserInfo.txt";

    // Map to store user information (username as key, User object as value)
    private Map<String, User> loginInfo;

    // Field to store the current logged-in user
    private User currentUser;

    // Constructor for the AuthenticationSystem class
    public AuthenticationSystem() {
        // Initialize the map to store user information
        loginInfo = new HashMap<>();
        // Load user information from the file during object creation
        loadUsers();
    }

    // Method to load user information from a file
    private void loadUsers() {
        // Use Java NIO Paths to get the file path
        Path filePath = Paths.get(USER_FILE_PATH);
        try (Scanner fileScanner = new Scanner(filePath.toFile())) {
            // Read each line from the file and split the line into username and password
            while (fileScanner.hasNextLine()) {
                String[] userInfo = fileScanner.nextLine().split(":");
                // Check if the userInfo array has at least 2 elements
                if (userInfo.length >= 2) {
                    // Create a new User object and add it to the loginInfo map
                    User user = new User(userInfo[0], userInfo[1]);
                    loginInfo.put(userInfo[0], user);
                }
            }
        } catch (IOException e) {
            // Print an error message if an exception occurs during file reading
            System.err.println("Error loading users from file: " + e.getMessage());
        }
    }

    // Method to save user information to a file
    private void saveUsers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE_PATH))) {
            // Iterate through the values (User objects) in the loginInfo map
            for (User user : loginInfo.values()) {
                // Write the username and password to the file separated by ':'
                writer.write(user.getUsername() + ":" + user.getPassword());
                // Add a new line to separate each user's information
                writer.newLine();
            }
        } catch (IOException e) {
            // Print an error message if an exception occurs during file writing
            System.err.println("Error saving users to file: " + e.getMessage());
        }
    }

    // Method to check if any user is currently logged in
    public boolean isLoggedIn() {
        return currentUser != null;
    }

    // Getter method to retrieve the current logged-in user
    public User getCurrentUser() {
        return currentUser;
    }

    // Setter method to set the current logged-in user
    private void setCurrentUser(User user) {
        currentUser = user;
    }

    // Method to log out the current user
    public void logout() {
        currentUser = null;
    }

    // Method to register a new user
    public void register(int roleChoice, String username, String password) {
        // Check if the roleChoice is a valid value (1 or 2)
        if (roleChoice != 1 && roleChoice != 2) {
            System.err.println("Invalid input!");
            return;
        }

        // Check if the username or password is empty
        if (username.isEmpty() || password.isEmpty()) {
            System.err.println("Error: Empty username or password. Registration failed.");
            return;
        }

        // Check if the username already exists
        if (loginInfo.containsKey(username)) {
            System.err.println("Error: Username already exists. Registration failed.");
            return;
        }

        // Create a new User object based on the roleChoice (Admin or Regular User)
        User newUser = (roleChoice == 2) ? new Admin(username, password) : new User(username, password);

        // Add the new user to the loginInfo map
        loginInfo.put(username, newUser);

        // Save the updated user information to the file
        saveUsers();

        // Print a success message
        System.out.println("Registration successful for username: " + username);
    }

    // Method to authenticate a user based on provided username and password
    public boolean authenticate(String username, String password) {
        // Get the User object associated with the provided username
        User authenticatedUser = loginInfo.get(username);

        // Check if the user exists and the provided password is correct
        if (authenticatedUser != null && authenticatedUser.authenticate(password)) {
            // Print a success message
            System.out.println("Authentication successful.");
            return true;
        } else {
            // Print an error message if authentication fails
            System.out.println("Authentication failed. Invalid username or password.");
            return false;
        }
    }

    // Method to log in a user based on provided username and password
    public int login(String username, String password) {
        // Get the User object associated with the provided username
        User authenticatedUser = loginInfo.get(username);

        // Check if the user exists and the provided password is correct
        if (authenticatedUser != null && authenticatedUser.authenticate(password)) {
            // Set the current logged-in user
            setCurrentUser(authenticatedUser);

            // Print a message based on the user's role (Admin or Regular User)
            if (authenticatedUser instanceof Admin) {
                System.out.println("Admin logged in!");
                return 1; // Return 1 for Admin
            } else {
                System.out.println("Regular user logged in!");
                return 0; // Return 0 for Regular User
            }
        } else {
            // Print an error message if authentication fails
            System.out.println("Authentication failed. Invalid username or password.");
            return 2; // Return 2 for Authentication Failure
        }
    }
}
