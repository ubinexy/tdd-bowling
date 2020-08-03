import java.util.stream.Stream;

public class BowlingGame {
    private Integer[] score;
    private int firstThrow;
    private int secondThrow;
    private int finishedFrame;

    public BowlingGame() {
        score = new Integer[10];
        for(int i = 0; i < 10; i++) {
            score[i] = 0;
        }
        firstThrow = -1;
        secondThrow = -1;
        finishedFrame = 0;
    }

    public int getScore() {
        return Stream.of(score).reduce(0, Integer::sum);
    }

    public void throwBowling(int knockedPins) {
        if(firstThrow < 0) {
            firstThrow = knockedPins;
        } else {
            secondThrow = knockedPins;
            check();
        }
    }

    public void check() {
        score[0] = firstThrow + secondThrow;

        firstThrow = -1;
        secondThrow = -1;
    }
}
