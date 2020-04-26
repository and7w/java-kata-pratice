package kata.tdd.tenis;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class GameManagerTest {

    @Test
    public void shouldPlayBall(){
        GameManager gameManager = new GameManager();

        gameManager.playBall();

        Assertions.assertNotNull(gameManager.getCurrentBallWinner());
    }


}
