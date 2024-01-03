package TypingTestVer11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String username;
    private String password;
    private Map<String, List<Result>> resultsByLevel;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.resultsByLevel = new HashMap<>();
    }

    public User(String username, String password, Map<String, List<Result>> resultsByLevel) {
        this.username = username;
        this.password = password;
        this.resultsByLevel = resultsByLevel;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void addResult(String level, Result result) {
        resultsByLevel.computeIfAbsent(level, k -> new ArrayList<>()).add(result);
    }

    public Map<String, List<Result>> getResultsByLevel() {
        return resultsByLevel;
    }

    public String getUserInfo() {
        return username + ":" + password;
    }

    public boolean authenticate(String enteredPassword) {
        return password.equals(enteredPassword);
    }

    @Override
    public String toString() {
        return username + " / " + password + " / " + resultsByLevel;
    }
}