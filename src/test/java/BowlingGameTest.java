import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class BowlingGameTest {


    @Test
    void should_return_sum_when_get_score_given_knocked_pins_in_two_throws_are_less_then_10() {
        BowlingGame game = new BowlingGame();

        game.throwBowling(2);
        game.throwBowling(3);

        Assertions.assertEquals(5, game.getScore());
    }


    @Test
    void should_account_for_next_two_throws_when_get_score_given_a_strike() {
        BowlingGame game = new BowlingGame();

        game.throwBowling(10);
        game.throwBowling(3);
        game.throwBowling(5);
        Assertions.assertEquals(26, game.getScore());
    }

    @Test
    void should_account_for_next_throw_when_get_score_given_a_spare() {
        BowlingGame game = new BowlingGame();

        game.throwBowling(2);
        game.throwBowling(8);
        game.throwBowling(3);
        game.throwBowling(5);
        Assertions.assertEquals(21, game.getScore());
    }

    @Test
    void should_return_sum_when_get_score_given_three_throws_in_last_frame() {
        BowlingGame game = new BowlingGame();

        for(int i = 0; i < 18; i++) {
            game.throwBowling(0);
        }

        game.throwBowling(3);
        game.throwBowling(3);
        game.throwBowling(2);
        Assertions.assertEquals(8, game.getScore());
    }

    @Test
    void should_return_sum_when_get_score_given_a_strike_in_last_frame() {
        BowlingGame game = new BowlingGame();

        for(int i = 0; i < 18; i++) {
            game.throwBowling(0);
        }

        game.throwBowling(10);
        game.throwBowling(3);
        game.throwBowling(2);
        Assertions.assertEquals(15, game.getScore());
    }

    @Test
    void should_return_sum_when_get_score_given_a_spare_in_last_frame() {
        BowlingGame game = new BowlingGame();

        for(int i = 0; i < 18; i++) {
            game.throwBowling(0);
        }

        game.throwBowling(6);
        game.throwBowling(4);
        game.throwBowling(5);
        Assertions.assertEquals(15, game.getScore());
    }

    @Test
    void should_throw_exception_when_throwBowling_given_argument_is_greater_than_10(){
        BowlingGame game = new BowlingGame();

        Assertions.assertThrows(MyException.class, ()-> {
            game.throwBowling(11);
        });
    }

    @Test
    void should_throw_exception_when_throwBowling_given_argument_is_less_then_0(){
        BowlingGame game = new BowlingGame();

        Assertions.assertThrows(MyException.class, ()-> {
            game.throwBowling(-1);
        });
    }

    @Test
    void should_throw_exception_when_throwBowling_given_sum_of_the_two_throws_are_greater_than_10(){
        BowlingGame game = new BowlingGame();
        game.throwBowling(7);

        Assertions.assertThrows(MyException.class, ()-> {
            game.throwBowling(4);
        });
    }

    @Test
    void should_throw_exception_when_throwBowling_given_call_throwBowling_method_after_game_is_over(){
        BowlingGame game = new BowlingGame();

        for(int i = 0; i < 21; i++) {
            game.throwBowling(0);
        }

        Assertions.assertThrows(MyException.class, ()-> {
            game.throwBowling(4);
        });
    }
}
