package TypingTestVer12;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JFrame frame;
    private JPanel panel;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public TypingTestGame() {
        this.authSystem = new AuthenticationSystem();
        this.users = new ArrayList<>();
        this.typedWords = 0;
        this.correctWords = 0;
        this.wrongWords = 0;
        this.typingSpeed = 0.0;
        this.startTime = 0L;
        this.endTime = 0L;
        this.filePath = "/Users/oudomkhiev/Documents/study (Y2)/term3/OOC/project/TypingTestVer12/UserR.txt";
    }

    public void runGame() {
        frame = new JFrame("Typing Test Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Typing Test Game");
        titleLabel.setBounds(150, 20, 200, 25);
        panel.add(titleLabel);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(50, 80, 100, 25);
        panel.add(loginButton);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(250, 80, 100, 25);
        panel.add(registerButton);

        JButton playButton = new JButton("Play Typing Test");
        playButton.setBounds(50, 120, 200, 25);
        panel.add(playButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(250, 120, 100, 25);
        panel.add(exitButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleRegistration();
            }
        });

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectTypingTestLevel();
                playTypingTest();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Exiting program.");
                writeUserResultsToFile();
                System.exit(0);
            }
        });
    }


    

    private void selectTypingTestLevel() {
        do {
            String input = JOptionPane.showInputDialog("Select a typing test level:\n1. Easy\n2. Medium\n3. Hard");
    
            try {
                levelChoice = Integer.parseInt(input);
    
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
                    JOptionPane.showMessageDialog(null, "Invalid level choice. Please select the typing test level again.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid option.");
            }
        } while (levelChoice < 1 || levelChoice > 3);
    }
    
    private void playTypingTest() {
        String levelName = getLevelName(levelChoice);
        typedWords = 0;
        correctWords = 0;
        wrongWords = 0;

        JOptionPane.showMessageDialog(null, "Get ready to type!\nType the words exactly as shown.");

        Random random = new Random();

        startTime = System.currentTimeMillis();

        while (true) {
            if (System.currentTimeMillis() - startTime >= getTimeLimit() * 1000) {
                break;
            }

            String word = currentLevel.getRandomWord(random);
            String userInput = JOptionPane.showInputDialog(word + " > ");

            typedWords++;
            if (userInput != null && userInput.equals(word)) {
                correctWords++;
            } else {
                wrongWords++;
            }
        }
        endTime = System.currentTimeMillis();

        JOptionPane.showMessageDialog(null, "Time's up!");
        
        typingSpeed = calculateTypingSpeed(startTime, endTime, typedWords);
        typingSpeed = Math.round(typingSpeed * 100.0) / 100.0;

        displayResults(typedWords, correctWords, wrongWords, typingSpeed);
        Result result = new Result(typedWords, correctWords, wrongWords, getAccuracy(), typingSpeed);

        String username = authSystem.getCurrentUser().getUsername();
        String password = authSystem.getCurrentUser().getPassword();
        updateUserResults(username, password, levelName, result);
    }

    private void handleLogin() {
        usernameField = new JTextField();
        passwordField = new JPasswordField();

        Object[] fields = {"Username:", usernameField, "Password:", passwordField};
        int option = JOptionPane.showConfirmDialog(null, fields, "Login", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            int loginStatus = authSystem.login(username, password);

            switch (loginStatus) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Regular user logged in!");
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "Admin logged in!");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Authentication failed. Invalid username or password.");
                    break;
            }
        }
    }

    private void handleRegistration() {
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        JComboBox<String> roleComboBox = new JComboBox<>(new String[]{"Regular User", "Admin"});

        Object[] fields = {"Username:", usernameField, "Password:", passwordField, "Role:", roleComboBox};
        int option = JOptionPane.showConfirmDialog(null, fields, "Registration", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            int roleChoice = roleComboBox.getSelectedIndex() + 1;
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            users.add(new User(username, password));

            authSystem.register(roleChoice, username, password);
            JOptionPane.showMessageDialog(null, "Registration successful for username: " + username);
        }
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
