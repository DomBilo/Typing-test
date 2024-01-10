package TypingTestFinalVer;

// Class representing the result of a typing test
public class Result {
    // Fields to store typing test metrics
    private int typedWords;
    private int correctWords;
    private int wrongWords;
    private int accuracy;
    private double typingSpeed;

    // Constructor to initialize the Result object with typing test metrics
    public Result(int typedWords, int correctWords, int wrongWords, int accuracy, double typingSpeed) {
        this.typedWords = typedWords;
        this.correctWords = correctWords;
        this.wrongWords = wrongWords;
        this.accuracy = accuracy;
        this.typingSpeed = typingSpeed;
    }

    // Getter method to retrieve the number of typed words
    public int getTypedWords() {
        return typedWords;
    }

    // Getter method to retrieve the number of correctly typed words
    public int getCorrectWords() {
        return correctWords;
    }

    // Getter method to retrieve the number of wrongly typed words
    public int getWrongWords() {
        return wrongWords;
    }

    // Getter method to retrieve the accuracy percentage
    public int getAccuracy() {
        return accuracy;
    }

    // Getter method to retrieve the typing speed
    public double getTypingSpeed() {
        return typingSpeed;
    }

    // Override the toString method to provide a formatted string representation of the Result object
    @Override
    public String toString() {
        // Return a string containing typedWords, correctWords, wrongWords, accuracy, and typingSpeed
        return typedWords + "," + correctWords + ", " + wrongWords + "," + accuracy
                + "%," + typingSpeed;
    }
}
