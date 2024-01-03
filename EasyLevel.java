package TypingTestVer11;

import java.util.Random;

public class EasyLevel extends TypingTestLevel {
    public EasyLevel() {
        super();
        this.wordList = new String[]{"sun", "ice", "air", "eye", "dog", "cat", "ear", "bed", "pen", "toy", "sit", "eat", "run", "fun"};
    }

    @Override
    public String getRandomWord(Random random) {
        return wordList[random.nextInt(wordList.length)];
    }
}