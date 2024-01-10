package TypingTestFinalVer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    // Fields to store user information
    private String username;
    private String password;

    // Map to store typing test results by level
    private Map<String, List<Result>> resultsByLevel;

    // Constructor to create a new User object with username and password
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        // Initialize the map to store typing test results
        this.resultsByLevel = new HashMap<>();
    }

    // Constructor to create a new User object with username, password, and existing results
    public User(String username, String password, Map<String, List<Result>> resultsByLevel) {
        this.username = username;
        this.password = password;
        this.resultsByLevel = resultsByLevel;
    }

    // Getter method to retrieve the username
    public String getUsername() {
        return username;
    }

    // Getter method to retrieve the password
    public String getPassword() {
        return password;
    }

    // Method to add a typing test result for a specific level
    public void addResult(String level, Result result) {
        // If the level is not present in the map, create a new entry with an empty list
        resultsByLevel.computeIfAbsent(level, k -> new ArrayList<>()).add(result);
    }

    // Getter method to retrieve typing test results by level
    public Map<String, List<Result>> getResultsByLevel() {
        return resultsByLevel;
    }

    // Getter method to retrieve user information
    public String getUserInfo() {
        return username;
    }

    // Method to authenticate the user by comparing entered password with stored password
    public boolean authenticate(String enteredPassword) {
        return password.equals(enteredPassword);
    }

    // Override the toString method to provide a string representation of the User object
    @Override
    public String toString() {
        // Create a string representation containing username, password, and resultsByLevel
        StringBuilder resultString = new StringBuilder(username + ":" + password);
        if (!resultsByLevel.isEmpty()) {
            resultString.append(" / ").append(resultsByLevel);
        }
        return resultString.toString();
    }
}
