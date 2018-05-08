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
        String[][] rows = getRows();
        String[][] columns = getColumns();
        String[][] diagonals = getDiagonals();

       for(int i = 0; i < rows.length; i++) {
           if (lineHasWin(rows[i])) {
               return true;
           }
       }

        for(int i = 0; i < columns.length; i++) {
            if (lineHasWin(columns[i])) {
                return true;
            }
        }

        for(int i = 0; i < diagonals.length; i++) {
            if (lineHasWin(diagonals[i])) {
                return true;
            }
        }

       return false;
    }

    private boolean lineHasWin(String[] line) {
        return Arrays.stream(line).distinct().count() == 1;
    }

    private String[][] getRows() {
        int chunk = 3;
        int counter = 0;
        String[][] rows = new String[chunk][];

        for(int i = 0; i < grid.length; i += chunk) {
            rows[counter] = Arrays.copyOfRange(grid, i, i + chunk);
            counter++;
        }

        return rows;
    }

    private String[][] getColumns() {
        String[][] rows = getRows();
        String[][] columns = new String[getSide()][];

        for(int i = 0; i < getSide(); i++) {
            String[] column = new String[getSide()];

            for(int j = 0; j < getSide(); j++) {
                column[j] = rows[j][i];
            }
            columns[i] = column;
        }

        return columns;
    }

    private String[][] getDiagonals() {
        int side = getSide();
        int counter = side - 1;

        String[][] rows = getRows();
        String[] leftDiagonal = new String[side];
        String[] rightDiagonal = new String[side];
        String[][] diagonals = new String[side][];

        for(int i = 0; i < side; i++) {
            leftDiagonal[i] = rows[i][i];
            rightDiagonal[i] = rows[i][counter];
            counter--;
        }

        diagonals[0] = leftDiagonal;
        diagonals[1] = rightDiagonal;

        return diagonals;
    }

    private int getSide() {
        return (int)Math.sqrt(grid.length);
    }
}
