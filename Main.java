package TypingTestVT;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String tmpName;
        String tmpPassword;

        Scanner sc = new Scanner(System.in);
        String filePath = "UserInfo.txt";

        System.out.println("Input name: ");
        tmpName = sc.nextLine();
        System.out.println("Input Password: ");
        tmpPassword = sc.nextLine();

        User user = new User(tmpName, tmpPassword);

        String WritingContent = user.toString() + "\n";

        // Print the user information
        System.out.println("User is created");
        System.out.println(user);

        try {
            // Create a FileWriter with append mode set to true
            FileWriter fileWriter = new FileWriter(filePath, true);

            // Write the content to the file
            fileWriter.write(WritingContent);

            // Close the FileWriter to release resources
            fileWriter.close();

            System.out.println("Content appended to the file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }

        TypingTestBase level = null;
        int levelChoice = 0;

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Select a level:");
            System.out.println("1. Easy");
            System.out.println("2. Medium");
            System.out.println("3. Hard");

            try {
                levelChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (levelChoice) {
                    case 1:
                        level = new EasyLevel();
                        break;
                    case 2:
                        level = new MediumLevel();
                        break;
                    case 3:
                        level = new HardLevel();
                        break;
                }

                level.start();

                System.out.println("Do you want to play again? (y/n)");
                String playAgain = scanner.nextLine();

                if (!playAgain.equalsIgnoreCase("y")) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid level choice.");
                scanner.nextLine(); // Consume the invalid input
            }
        } while (true);


        scanner.close();
    }
}