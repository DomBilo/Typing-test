package TypingTestFinalVer;

import java.util.Random;

public abstract class TypingTestLevel {
    // Protected field to store an array of words for the typing test level
    protected String[] wordList;

    // Abstract method to be implemented by subclasses to get a random word from the wordList
    public abstract String getRandomWord(Random random);

    // Getter method to retrieve the entire wordList
    public String[] getWordList() {
        return wordList;
    }
}

