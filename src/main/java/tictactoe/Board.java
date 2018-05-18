package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private List<Cell> grid;

    public Board() {
        this.grid = new ArrayList<>(Arrays.asList(new Cell(1), new Cell(2), new Cell(3), new Cell(4), new Cell(5), new Cell(6), new Cell(7), new Cell(8), new Cell(9)));
    }

    public List<Cell> getGridAsList() {
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
            List<Cell> cells = grid.subList(i, i + side);
            rows.add(new Line(cells));
        }

        return rows;
    }

    private List<Line> getColumns() {
        List<Line> rows = getRows();
        List<Line> columns = new ArrayList<>();

        int side = getSide();

        for(int i = 0; i < side; i++) {
            List<Cell> column = new ArrayList<>();
            for(Line row : getRows()) {
                column.add(row.getCellAtPosition(i));
            }

            columns.add(new Line(column));
        }

        return columns;
    }

    private List<Line> getDiagonals() {
        List<Line> diagonals = new ArrayList<>();
        List<Cell> leftDiagonal = new ArrayList<>();
        List<Cell> rightDiagonal = new ArrayList<>();

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

    public void markCellAtPosition(String mark, String input) {
        if(isValidInput(input)) {
            int position = Integer.parseInt(input);
            Cell cell = grid.get(position - 1);
            cell.setMark(mark);
        } else {
            throw new InvalidInputException("Invalid input, please enter a number between 1 and 9.");
        }
    }

    public String getWinner() {
        if(!hasWin()) { return ""; }
        return getLines().stream().filter(Line::hasWin).findFirst().get().winningMark();
    }

    public Cell getCellAtPosition(int position) {
        return grid.get(position - 1);
    }

    public static boolean isValidInput(String input) {
        List<String> acceptedInputs = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
        return acceptedInputs.contains(input);
    }
}
