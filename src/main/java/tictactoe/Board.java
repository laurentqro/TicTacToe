package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private List<String> grid;

    public Board() {
        this.grid = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
    }

    public List<String> getGridAsList() {
        return grid;
    }


    public boolean hasWin() {
        for(Line line : getLines()) {
            if (line.hasWin()) {
                return true;
            }
        }

       return false;
    }

    public boolean hasTie() {
        return isFull() & !hasWin();
    }

    private List<Line> getLines() {
        List<Line> lines = new ArrayList<>();

        lines.addAll(getRows());
        lines.addAll(getColumns());
        lines.addAll(getDiagonals());

        return lines;
    }

    private List<Line> getRows() {
        int side = getSide();
        List<Line> rows = new ArrayList<>();

        for(int i = 0; i < grid.size(); i += side) {
            List<String> cells = grid.subList(i, i + side);
            rows.add(new Line(cells));
        }

        return rows;
    }

    private List<Line> getColumns() {
        List<Line> rows = getRows();
        List<Line> columns = new ArrayList<>();

        int side = getSide();

        for(int i = 0; i < side; i++) {
            List<String> column = new ArrayList<>();
            for(Line row : getRows()) {
                column.add(row.getCellAtPosition(i));
            }

            columns.add(new Line(column));
        }

        return columns;
    }

    private List<Line> getDiagonals() {
        List<Line> diagonals = new ArrayList<>();
        List<String> leftDiagonal = new ArrayList<>();
        List<String> rightDiagonal = new ArrayList<>();

        int side = getSide();
        int counter = side - 1;
        for(int i = 0; i < side; i++) {
            leftDiagonal.add(getRows().get(i).getCellAtPosition(i));
            rightDiagonal.add(getRows().get(i).getCellAtPosition(counter));
            counter--;
        }

        diagonals.add(new Line(leftDiagonal));
        diagonals.add(new Line(rightDiagonal));

        return diagonals;
    }

    private boolean isFull() {
        return getLines().stream().allMatch(Line::isFull);
    }

    private int getSide() {
        return (int)Math.sqrt(grid.size());
    }

    public void mark(String symbol, int position) {
        grid.set(position - 1, symbol);
    }

    public String getWinner() {
        if (!hasWin()) return "";
        return getLines().stream().filter(Line::hasWin).findFirst().get().winningMark();
    }
}
