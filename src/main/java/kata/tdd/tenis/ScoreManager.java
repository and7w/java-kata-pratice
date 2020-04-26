package kata.tdd.tenis;

/**
 * class responsabilities
 * 1. init Game
 * 2. play
 * 3. end the game
 */
public class ScoreManager {
    public final GameManager gameManager = new GameManager();

    public ScoreManager() {
    }

    public void updateScore() {
        Score player1Score = this.gameManager.getPlayerGame1().getScore();
        Score player2Score = this.gameManager.getPlayerGame2().getScore();

        if (this.gameManager.getCurrentBallWinner().equals(gameManager.getPlayerGame1())) {
            gameManager.getPlayerGame1().setScore(updateFromCurrentWhenWin(player1Score, player2Score));
            gameManager.getPlayerGame2().setScore(updateFromCurrentWhenLost(player2Score));
        }

        if (this.gameManager.getCurrentBallWinner().equals(gameManager.getPlayerGame2())) {
            gameManager.getPlayerGame2().setScore(updateFromCurrentWhenWin(player2Score, player1Score));
            gameManager.getPlayerGame1().setScore(updateFromCurrentWhenLost(player1Score));
        }

    }


    private Score updateFromCurrentWhenLost(Score ballLooserScore) {
        if(ballLooserScore.equals(Score._A)){
            return Score._40;
        }
        return ballLooserScore;
    }

    private Score updateFromCurrentWhenWin(Score ballWinnerScore, Score ballLooserScore){
         switch (ballWinnerScore) {
             case _0: return Score._15;
             case _15: return Score._30;
             case _30: return Score._40;
             case _40:
                 return updateScoreWhenBallWinnerHas40(ballLooserScore);
             case _A: return Score._WIN;
             default: return null;
         }
    }

    private Score updateScoreWhenBallWinnerHas40(Score ballLooserScore) {
        if(ballLooserScore.equals(Score._A)){
            return Score._40;
        }
        if(ballLooserScore.equals(Score._40) ){
            return Score._A;
        }
        return Score._WIN;
    }
}
