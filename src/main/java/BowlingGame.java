import java.util.stream.Stream;

public class BowlingGame {
    private Integer[] score;
    private int firstThrow = -1;
    private int secondThrow = 0;
    private int frameIndex;
    private boolean islastThrowSpare = false;
    private boolean islastThrowStrike = false;

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
        if(islastThrowStrike || islastThrowSpare)
            score[frameIndex -1] += knockedPins;

        if(frameIndex == 9) {
            LastFrame(knockedPins);
            return;
        }

        if(isFirstThrow()) {
            firstThrow = knockedPins;
            if(knockedPins == 10) {
                updateFrameState();
            }
        } else {
            secondThrow = knockedPins;
            updateFrameState();
        }
        updateLastThrowState(knockedPins);
    }

    public void LastFrame(int knockedPins) {
        score[frameIndex] += knockedPins;

        if(islastThrowStrike) {
            islastThrowStrike = false;
            islastThrowSpare = true;
        } else if(islastThrowSpare) {
            islastThrowSpare = false;
        }
    }

    private void updateLastThrowState(int knockedPins) {
        if(knockedPins == 10) {
            islastThrowStrike = true;
        } else if(islastThrowStrike) {
            islastThrowStrike = false;
            islastThrowSpare = true;
        } else if(frameIndex > 0 && score[frameIndex -1] == 10) {
            islastThrowSpare = true;
        } else {
            islastThrowSpare = false;
        }
    }

    private boolean isFirstThrow() {
        return firstThrow < 0;
    }

    private void updateFrameState() {
        score[frameIndex] = firstThrow + secondThrow;

        firstThrow = -1;
        secondThrow = 0;
        frameIndex++;
    }
}
