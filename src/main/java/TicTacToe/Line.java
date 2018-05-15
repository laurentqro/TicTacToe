package TicTacToe;

import java.util.List;

public class Line {
    private List<String> cells;

    public Line(List<String> cells) {
        this.cells = cells;
    }

    public String getCellAtPosition(int position) {
        return cells.get(position);
    }

    public boolean hasWin() {
        return cells.stream().distinct().count() == 1;
    }

    public boolean isFull() {
        return cells.stream().allMatch(cell -> (cell == "X" || cell == "O"));
    }

    public String winningMark() {
       return cells.stream().distinct().findFirst().get();
    }
}