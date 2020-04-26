package kata.tdd.tenis;

public class GameResult {
    Player winnerPlayer;
    Player looserPlayer;
    boolean isGameOver;


    public Player getWinnerPlayer() {
        return winnerPlayer;
    }

    public void setWinnerPlayer(Player winnerPlayer) {
        this.winnerPlayer = winnerPlayer;
    }

    public Player getLooserPlayer() {
        return looserPlayer;
    }

    public void setLooserPlayer(Player looserPlayer) {
        this.looserPlayer = looserPlayer;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }
}
