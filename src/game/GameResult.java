package game;

public class GameResult {




    boolean isOver;
    String winner;

    @Override
    public String toString() {
        return "GameResult{" +
                "isOver=" + isOver +
                ", winner='" + winner + '\'' +
                '}';
    }

    public GameResult(boolean isOver, String winner) {
        this.isOver = isOver;
        this.winner = winner;
    }

    public boolean isOver() {
        return isOver;
    }

    public String getWinner() {
        return winner;
    }
}
