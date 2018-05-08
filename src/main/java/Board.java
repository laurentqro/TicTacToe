import java.util.Arrays;

public class Board {
    private String[] grid;

    public Board() {
        this.grid = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    }

    public String[] getGrid() {
        return grid;
    }

    public void setGrid(String[] grid) {
        this.grid = grid;
    }

    public boolean hasWin() {
        return (   lineHasWin(line1())
                || lineHasWin(line2())
                || lineHasWin(line3())
                || lineHasWin(column1())
                || lineHasWin(column2())
                || lineHasWin(column3())
                || lineHasWin(diagonal1())
                || lineHasWin(diagonal2())
        );
    }

    private boolean lineHasWin(String[] line) {
        return Arrays.stream(line).distinct().count() == 1;
    }

    private String[] line1() {
        String[] line = new String[]{this.grid[0], this.grid[1], this.grid[2]};
        return line;
    }

    private String[] line2() {
        String[] line = new String[]{this.grid[3], this.grid[4], this.grid[5]};
        return line;
    }

    private String[] line3() {
        String[] line = new String[]{this.grid[6], this.grid[7], this.grid[8]};
        return line;
    }

    private String[] column1() {
        String[] column = new String[]{this.grid[0], this.grid[3], this.grid[6]};
        return column;
    }

    private String[] column2() {
        String[] column = new String[]{this.grid[1], this.grid[4], this.grid[7]};
        return column;
    }

    private String[] column3() {
        String[] column = new String[]{this.grid[2], this.grid[5], this.grid[8]};
        return column;
    }

    private String[] diagonal1() {
        String[] diagonal = new String[]{this.grid[0], this.grid[4], this.grid[8]};
        return diagonal;
    }

    private String[] diagonal2() {
        String[] diagonal = new String[]{this.grid[2], this.grid[4], this.grid[6]};
        return diagonal;
    }
}
