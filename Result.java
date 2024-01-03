package TypingTestVer11;

public class Result {
    private int typedWords;
    private int correctWords;
    private int wrongWords;
    private int accuracy;
    private double typingSpeed;

    public Result(int typedWords, int correctWords, int wrongWords, int accuracy, double typingSpeed) {
        this.typedWords = typedWords;
        this.correctWords = correctWords;
        this.wrongWords = wrongWords;
        this.accuracy = accuracy;
        this.typingSpeed = typingSpeed;
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
        return accuracy;
    }

    public double getTypingSpeed() {
        return typingSpeed;
    }

    @Override
    public String toString() {
        return typedWords + "," + correctWords + ", " + wrongWords + "," + accuracy
                + "%," + typingSpeed;
    }
}
