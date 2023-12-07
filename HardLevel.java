package TypingTestVT;

public class HardLevel extends TypingTestBase {
    private static final String[] wordList = {"Encyclopedia", "University", "Examination", "Achievement", "challenge", "Availability", "Environmental", "Accidentally"};

    public HardLevel() {
        super(wordList);
    }

    @Override
    protected int getTimeLimit() {
        return 120;
    }
}
