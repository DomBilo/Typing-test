package TypingTestVer12;

import java.util.Random;

public class MediumLevel extends TypingTestLevel {

    public MediumLevel() {
        super();
        this.wordList = new String[]{"Happy", "Light", "Never", "Water", "Funny", "World", "Often", "Laugh", "Think", "Clean", "Music", "Dance", "Love", "Thank", "Read"};
    }
    @Override
    public String getRandomWord(Random random) {
        return wordList[random.nextInt(wordList.length)];
    }
}
