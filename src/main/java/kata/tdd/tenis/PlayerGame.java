package kata.tdd.tenis;

public class PlayerGame {
    private Player player;
    private Score score;
    private Boolean hasAdvantage;
    private Boolean hasWin;

    public PlayerGame(){
        this.player = new Player();
        this.score = Score._0;
        this.hasAdvantage = false;
        this.hasWin = false;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public Boolean getHasAdvantage() {
        return hasAdvantage;
    }

    public void setHasAdvantage(Boolean hasAdvantage) {
        this.hasAdvantage = hasAdvantage;
    }

    public Boolean getHasWin() {
        return hasWin;
    }

    public void setHasWin(Boolean hasWin) {
        this.hasWin = hasWin;
    }
}
