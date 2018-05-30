package tictactoe;

public class ScoredMove {
    private Cell cell;
    private int score;

    public ScoredMove(Cell cell, int score) {
        this.cell = cell;
        this.score = score;
    }

    public int getCellPosition() {
        return cell.getPosition();
    }

    public int getScore() {
        return score;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
