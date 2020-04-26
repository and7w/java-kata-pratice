package kata.tdd.tenis;

import java.util.Random;

public class GameManager {
    private PlayerGame playerGame1;
    private PlayerGame playerGame2;
    private PlayerGame currentBallWinner;

    public GameManager() {
        this.playerGame1 = new PlayerGame();
        this.playerGame2 = new PlayerGame();
    }


    public void playBall() {
        Random rand = new Random();
        int val = rand.nextInt() ;
        if( Math.abs(val% 2) == 1){
            this.currentBallWinner = playerGame2;
        }else{
            this.currentBallWinner = playerGame1;
        }
        //System.out.printf("%d %d\n",val, Math.abs(val% 2));
    }



    public PlayerGame getPlayerGame1() {
        return playerGame1;
    }

    public void setPlayerGame1(PlayerGame playerGame1) {
        this.playerGame1 = playerGame1;
    }

    public PlayerGame getPlayerGame2() {
        return playerGame2;
    }

    public void setPlayerGame2(PlayerGame playerGame2) {
        this.playerGame2 = playerGame2;
    }

    public PlayerGame getCurrentBallWinner() {
        return currentBallWinner;
    }

    public void setCurrentBallWinner(PlayerGame currentBallWinner) {
        this.currentBallWinner = currentBallWinner;
    }


}