package TypingTestVT;

public class EasyLevel extends TypingTestBase {
    private static final String[] wordList = {"apple", "banana", "cat", "dog", "grape", "sad", "happy", "new"};

    public EasyLevel() {
        super(wordList);
    }

    @Override
    protected int getTimeLimit() {
        return 10;
    }
}



