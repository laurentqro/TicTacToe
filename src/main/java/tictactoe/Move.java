package tictactoe;

public class Move {
    private int position;
    private int score;

    public Move(int position, int score) {
        this.position = position;
        this.score = score;
    }

    public int getPosition() {
        return position;
    }

    public int getScore() {
        return score;
    }
}
