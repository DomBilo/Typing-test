package TypingTestVer11;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TypingTestGame {
    private AuthenticationSystem authSystem;
    private List<User> users;
    private TypingTestLevel currentLevel;
    private int typedWords;
    private int correctWords;
    private int wrongWords;
    private double typingSpeed;
    private long startTime;
    private long endTime;
    private String filePath;
    private int levelChoice;

    public TypingTestGame() {
        this.authSystem = new AuthenticationSystem();
        this.users = new ArrayList<>();
        this.typedWords = 0;
        this.correctWords = 0;
        this.wrongWords = 0;
        this.typingSpeed = 0.0;
        this.startTime = 0L;
        this.endTime = 0L;
        this.filePath = "/Users/vatteyou/TypingTest/TypingTestVer9/user.txt";
    }

    public void runGame() {
        Scanner scanner = new Scanner(System.in);
    
        int loginStatus;
        do {
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Play Typing Test");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
    
            // Check if the input is an integer
            if (scanner.hasNextInt()) {
                int option = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
    
                switch (option) {
                    case 1:
                        loginStatus = handleLogin(scanner);
                        break;
                    case 2:
                        handleRegistration(scanner);
                        break;
                    case 3:
                        if (authSystem.isLoggedIn()) {
                            selectTypingTestLevel(scanner);
                            playTypingTest(scanner);
                        } else {
                            System.out.println("Please login first.");
                        }
                        break;
                    case 4:
                        System.out.println("Exiting program.");
                        scanner.close();
                        writeUserResultsToFile();
                        return;
                    default:
                        System.out.println("Invalid option. Please choose the option again.");
                }
            } else {
                // Handle non-integer input
                System.out.println("Invalid input. Please enter a valid option.");
                scanner.nextLine(); // Consume the invalid input
            }
        } while (true);
    }
    

    private void selectTypingTestLevel(Scanner scanner) {
        do {
            System.out.println("Select a typing test level:");
            System.out.println("1. Easy");
            System.out.println("2. Medium");
            System.out.println("3. Hard");
            System.out.print("Choose a level: ");
    
            // Check if the input is an integer
            if (scanner.hasNextInt()) {
                levelChoice = scanner.nextInt();  // Assign directly to the class variable
                scanner.nextLine(); // Consume newline character
    
                if (levelChoice >= 1 && levelChoice <= 3) {
                    switch (levelChoice) {
                        case 1:
                            currentLevel = new EasyLevel();
                            break;
                        case 2:
                            currentLevel = new MediumLevel();
                            break;
                        case 3:
                            currentLevel = new HardLevel();
                            break;
                    }
                } else {
                    System.out.println("Invalid level choice. Please select the typing test level again.");
                }
            } else {
                // Handle non-integer input
                System.out.println("Invalid input. Please enter a valid option.");
                scanner.nextLine(); // Consume the invalid input
            }
        } while (levelChoice < 1 || levelChoice > 3);
    }
    
    private void playTypingTest(Scanner scanner) {
        String levelName = getLevelName(levelChoice);
        typedWords = 0;
        correctWords = 0;
        wrongWords = 0;
    
        System.out.println("Get ready to type!");
        System.out.println("Type the words exactly as shown.");
    
        Random random = new Random();
    
        startTime = System.currentTimeMillis();

        while (true) {
            if (System.currentTimeMillis() - startTime >= getTimeLimit() * 1000) {
                break;
            }

            String word = currentLevel.getRandomWord(random);
            System.out.print(word + " > ");
            String userInput = scanner.nextLine();

            typedWords++;
            if (userInput.equals(word)) {
                correctWords++;
            } else {
                wrongWords++;
            }
        }

        endTime = System.currentTimeMillis();

        System.out.println("\nTime's up!");

        typingSpeed = calculateTypingSpeed(startTime, endTime, typedWords);
        typingSpeed = Math.round(typingSpeed * 100.0) / 100.0;

        displayResults(typedWords, correctWords, wrongWords, typingSpeed);
        Result result = new Result(typedWords, correctWords, wrongWords, getAccuracy(), typingSpeed);

        String username = authSystem.getCurrentUser().getUsername();
        String password = authSystem.getCurrentUser().getPassword();
        updateUserResults(username, password, levelName, result);
    }

    private int handleLogin(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        int loginStatus = authSystem.login(username, password);
        switch (loginStatus) {
            case 0:
                System.out.println("Regular user logged in!");
                break;
            case 1:
                System.out.println("Admin logged in!");
                break;
            case 2:
                System.out.println("Authentication failed. Invalid username or password.");
                break;
        }
        return loginStatus;
    }

    private void handleRegistration(Scanner scanner) {
        int roleChoice = 0;  // Initialize to a default value
        do {
            System.out.println("1. Regular User");
            System.out.println("2. Admin");
            System.out.print("Choose user role: ");
    
            // Check if the input is an integer
            if (scanner.hasNextInt()) {
                roleChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
    
                if (roleChoice == 1 || roleChoice == 2) {
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
    
                    users.add(new User(username, password));
    
                    authSystem.register(roleChoice, username, password);
                } else {
                    System.out.println("Invalid role choice. Please choose the option again.");
                }
            } else {
                // Handle non-integer input
                System.out.println("Invalid input. Please enter a valid option.");
                scanner.nextLine(); // Consume the invalid input
            }
        } while (roleChoice != 1 && roleChoice != 2);
    }


    private void displayResults(int typedWords, int correctWords, int wrongWords, double typingSpeed) {
        int totalWords = correctWords + wrongWords;
        int accuracy = (int) ((double) correctWords / totalWords * 100);

        System.out.println("Typed Words: " + typedWords);
        System.out.println("Correct Words: " + correctWords);
        System.out.println("Wrong Words: " + wrongWords);
        System.out.println("Accuracy: " + accuracy + "%");
        System.out.println("Typing Speed: " + typingSpeed + " words per second");
    }

    private void writeUserResultsToFile() {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            for (User user : users) {
                fileWriter.write(user.toString());
                fileWriter.write("\n"); // Separator between users
            }
            System.out.println("User information and results written to the file successfully.");
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }
    private void updateUserResults(String username, String password, String levelName, Result result) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                // If the user exists, add the result to the existing user
                user.addResult(levelName, result);
                return;
            }
        }
    
        // If the user does not exist, create a new user and add the result
        User newUser = new User(username, password);
        newUser.addResult(levelName, result);
        users.add(newUser);
    }
    

    private double calculateTypingSpeed(long startTime, long endTime, int typedWords) {
        long elapsedTime = endTime - startTime;
        double typingSpeed = (double) typedWords / elapsedTime * 1000;
        return typingSpeed;
    }

    private int getAccuracy() {
        int totalWords = correctWords + wrongWords;
        int accuracy = (int) ((double) correctWords / totalWords * 100);
        return accuracy;
    }

    private static final int TIME_LIMIT = 10; // seconds

    private int getTimeLimit() {
        return TIME_LIMIT;
    }
    private String getLevelName(int levelChoice) {
        switch (levelChoice) {
            case 1:
                return "Easy";
            case 2:
                return "Medium";
            case 3:
                return "Hard";
            default:
                throw new IllegalArgumentException("Invalid level choice");
        }
    }
}
