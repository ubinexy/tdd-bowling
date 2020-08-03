import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class BowlingGameTest {


    @Test
    void should_return_sum_when_get_score_given_knocked_pins_in_two_throws_are_less_then_10() {
        BowlingGame game = new BowlingGame();

        game.throwBowling(2);
        game.throwBowling(3);

        Assertions.assertEquals(game.getScore(), 5);
    }
}
