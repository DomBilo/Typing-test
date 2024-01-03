package TypingTestVer11;

import java.util.Random;

public class HardLevel extends TypingTestLevel {

    public HardLevel() {
        super();
        this.wordList = new String[]{"Brainstorm", "Understand", "Magnificent", "Comfortable", "Disappointed", "Unexpected", "Unfortunately", "Responsibility", "Independence", "Relationship", "Wonderful", "Delicious", "Magnificent", "Congratulations", "Unbelievable"};
    }
     @Override
    public String getRandomWord(Random random) {
        return wordList[random.nextInt(wordList.length)];
    }
}


