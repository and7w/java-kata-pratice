package kata.tdd.tenis;



import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class ScoreManagerTest {
    ScoreManager scoreManager;
    GameManager gameManager;


    @BeforeEach
   public void setup(){
       //given
       scoreManager = new ScoreManager();
       gameManager = scoreManager.gameManager;
   }

    //etant donné une partie
    //si le joueur 1 a pour score 0
    //et le joueur 2 a pour score 0
    //et que le jouer le 1 gagne alors alors le joueur 1 a pour score 15 et le 2 0
    @Test
    public void player1ShouldWinTheFirstBallAfterPlay(){
        //given
        gameManager.setCurrentBallWinner(gameManager.getPlayerGame1());
        //when
        scoreManager.updateScore();

        //then
        Assertions.assertThat(gameManager.getPlayerGame1().getScore()).isEqualTo(Score._15);
        Assertions.assertThat(gameManager.getPlayerGame2().getScore()).isEqualTo(Score._0);
    }

    //etant donné une partie
    //si le joueur 1 a pour score 30
    //et le joueur 2 a pour score 15
    //et que le jouer le 2 gagne alors ils ont le même score
    @Test
    public void playersShouldHaveTheScore_30(){
        //given
        gameManager.getPlayerGame1().setScore(Score._30);
        gameManager.getPlayerGame2().setScore(Score._15);
        gameManager.setCurrentBallWinner(gameManager.getPlayerGame2());


        //when
        scoreManager.updateScore();

        //then
        Assertions.assertThat(gameManager.getPlayerGame1().getScore()).isEqualTo(Score._30);
        Assertions.assertThat(gameManager.getPlayerGame2().getScore()).isEqualTo(Score._30);
    }

    //etant donné une partie
    //si le joueur 1 a pour score 30
    //et le joueur 2 a pour score 30
    //et que le joueur le 2 gagne alors le joueur 2 a 40 et le 1 30
    @Test
    public void players2ShouldHaveTheScore_40(){
        //given
        gameManager.getPlayerGame1().setScore(Score._30);
        gameManager.getPlayerGame2().setScore(Score._30);
        gameManager.setCurrentBallWinner(gameManager.getPlayerGame2());


        //when
        scoreManager.updateScore();

        //then
        Assertions.assertThat(gameManager.getPlayerGame1().getScore()).isEqualTo(Score._30);
        Assertions.assertThat(gameManager.getPlayerGame2().getScore()).isEqualTo(Score._40);
    }

    //etant donné une partie
    //si le joueur 1 a pour score 40
    //et le joueur 2 a pour score 40
    //et que le joueur le 2 gagne alors le joueur 2 a 40 à l'Avantage
    @Test
    public void players2ShouldHaveTheAdavantage(){
        //given
        gameManager.getPlayerGame1().setScore(Score._40);
        gameManager.getPlayerGame2().setScore(Score._40);
        gameManager.setCurrentBallWinner(gameManager.getPlayerGame2());

        //when
        scoreManager.updateScore();

        //then
        Assertions.assertThat(gameManager.getPlayerGame1().getScore()).isEqualTo(Score._40);
        Assertions.assertThat(gameManager.getPlayerGame2().getScore()).isEqualTo(Score._A);
    }

    //etant donné une partie
    //si le joueur 1 a pour score 40
    //et le joueur 2 a pour score A
    //et que le joueur le 1 gagne alors le joueur 1 a 40 et le joueur 2 aussi
    @Test
    public void playersShouldHave40(){
        //given
        gameManager.getPlayerGame1().setScore(Score._40);
        gameManager.getPlayerGame2().setScore(Score._A);
        gameManager.setCurrentBallWinner(gameManager.getPlayerGame1());


        //when
        scoreManager.updateScore();

        //then
        Assertions.assertThat(gameManager.getPlayerGame1().getScore()).isEqualTo(Score._40);
        Assertions.assertThat(gameManager.getPlayerGame2().getScore()).isEqualTo(Score._40);
    }

    //etant donné une partie
    //si le joueur 1 a pour score 40
    //et le joueur 2 a pour score A
    //et que le joueur le 2 gagne alors le joueur 1 a 40 et le joueur 2 WIN
    @Test
    public void players2ShouldHaveWin(){
        //given
        gameManager.getPlayerGame1().setScore(Score._40);
        gameManager.getPlayerGame2().setScore(Score._A);
        gameManager.setCurrentBallWinner(gameManager.getPlayerGame2());

        //when
        scoreManager.updateScore();

        //then
        Assertions.assertThat(gameManager.getPlayerGame1().getScore()).isEqualTo(Score._40);
        Assertions.assertThat(gameManager.getPlayerGame2().getScore()).isEqualTo(Score._WIN);
    }

    //etant donné une partie
    //si le joueur 1 a pour score 40
    //et le joueur 2 a pour score 15
    //et que le joueur le 1 gagne la partie alors le joueur 2 a 15 et le joueur 1 WIN
    @Test
    public void players1ShouldHaveWin(){
        //given
        gameManager.getPlayerGame1().setScore(Score._40);
        gameManager.getPlayerGame2().setScore(Score._15);
        gameManager.setCurrentBallWinner(gameManager.getPlayerGame1());

        //when
        scoreManager.updateScore();

        //then
        Assertions.assertThat(gameManager.getPlayerGame1().getScore()).isEqualTo(Score._WIN);
        Assertions.assertThat(gameManager.getPlayerGame2().getScore()).isEqualTo(Score._15);
    }



}
