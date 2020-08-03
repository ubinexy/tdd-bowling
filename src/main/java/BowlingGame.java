import java.util.stream.Stream;

public class BowlingGame {
    private Integer[] score;
    private int firstThrow = -1;
    private int secondThrow = 0;
    private int frameIndex;
    private boolean islastThrowSpare = false;

    public BowlingGame() {
        score = new Integer[10];
        for(int i = 0; i < 10; i++) {
            score[i] = 0;
        }
        frameIndex = 0;
    }

    public int getScore() {
        return Stream.of(score).reduce(0, Integer::sum);
    }

    public void throwBowling(int knockedPins) {
        if(islastThrowSpare) {
            score[frameIndex -1] += knockedPins;
        }

        if(isFirstThrow()) {
            firstThrow = knockedPins;
            if(knockedPins == 10) {
                frameOver();
            }
        } else {
            secondThrow = knockedPins;
            frameOver();
        }

        if(frameIndex > 0 && score[frameIndex -1] == 10) {
            islastThrowSpare = true;
        } else {
            islastThrowSpare = false;
        }
    }

    private boolean isFirstThrow() {
        return firstThrow < 0;
    }

    private void frameOver() {
        score[frameIndex] = firstThrow + secondThrow;

        firstThrow = -1;
        secondThrow = 0;
        frameIndex++;
    }
}
