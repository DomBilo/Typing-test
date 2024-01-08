package TypingTestVer12;

import java.util.Random;

public abstract class TypingTestLevel {
    protected String[] wordList;

    public abstract String getRandomWord(Random random);

    public String[] getWordList() {
        return wordList;
    }
}
