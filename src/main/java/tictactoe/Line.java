package tictactoe;

import java.util.List;

public class Line {
    private List<Cell> cells;

    public Line(List<Cell> cells) {
        this.cells = cells;
    }

    public Cell getCellAtPosition(int position) {
        return cells.get(position);
    }

    public boolean hasWin() {
        return isFull() & cells.stream().filter(Cell::isMarked).map(Cell::getMark).distinct().count() == 1;
    }

    public boolean isFull() {
        return cells.stream().allMatch(Cell::isMarked);
    }

    public String winningMark() {
       return cells.stream().distinct().findFirst().get().getMark();
    }
}
