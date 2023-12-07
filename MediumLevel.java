package TypingTestVT;

public class MediumLevel extends TypingTestBase {
    private static final String[] wordList = {"computer", "programming", "keyboard", "monitor", "mouse", "algorithm", "object", "software"};

    public MediumLevel() {
        super(wordList);
    }

    @Override
    protected int getTimeLimit() {
        return 90;
    }
}