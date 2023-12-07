package TypingTestVT;

import java.util.Random;
import java.util.Scanner;

public abstract class TypingTestBase {
    private String[] wordList;
    private int typedWords;
    private int correctWords;
    private int wrongWords;
    private long startTime;

    public TypingTestBase(String[] wordList) {
        this.wordList = wordList;
        this.typedWords = 0;
        this.correctWords = 0;
        this.wrongWords = 0;
    }

    public void start() {
        System.out.println("Get ready to type!");
        System.out.println("Type the words exactly as shown.");

        typedWords = 0;
        correctWords = 0;
        wrongWords = 0;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        startTime = System.currentTimeMillis();

        while (true) {
            if (System.currentTimeMillis() - startTime >= getTimeLimit() * 1000) {
                break;
            }

            String word = wordList[random.nextInt(wordList.length)];
            System.out.print(word + " > ");
            String userInput = scanner.nextLine();

            typedWords++;
            if (userInput.equals(word)) {
                correctWords++;
            } else {
                wrongWords++;
            }
        }

        System.out.println("\nTime's up!");

        double elapsedTimeInMinutes = (System.currentTimeMillis() - startTime) / 1000.0 / 60.0;
        int typingSpeed = calculateTypingSpeed(correctWords, elapsedTimeInMinutes);

        displayResults(typedWords, correctWords, wrongWords, typingSpeed);
    }

    protected abstract int getTimeLimit();

    protected void displayResults(int typedWords, int correctWords, int wrongWords, int typingSpeed) {
        int totalWords = correctWords + wrongWords;
        int accuracy = (int) ((double) correctWords / totalWords * 100);

        System.out.println("Typed Words: " + typedWords);
        System.out.println("Correct Words: " + correctWords);
        System.out.println("Wrong Words: " + wrongWords);
        System.out.println("Accuracy: " + accuracy + "%");
        System.out.println("Typing Speed: " + typingSpeed + " characters per second");
    }

    protected int calculateTypingSpeed(int correctWords, double elapsedTimeInMinutes) {
        double typingSpeed = correctWords / elapsedTimeInMinutes;
        return (int) typingSpeed;
    }

    protected String getRandomWord(Random random) {
        return null;
    }

    public int getTypedWords() {
        return typedWords;
    }

    public int getCorrectWords() {
        return correctWords;
    }

    public int getWrongWords() {
        return wrongWords;
    }

    public int getAccuracy() {
        int totalWords = correctWords + wrongWords;
        return (int) ((double) correctWords / totalWords * 100);
    }

    public int getTypingSpeed() {
        double elapsedTimeInMinutes = (System.currentTimeMillis() - startTime) / 1000.0 / 60.0;
        return calculateTypingSpeed(correctWords, elapsedTimeInMinutes);
    }
}