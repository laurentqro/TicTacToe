import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {
    @Test
    public void boardHasWinLine1() {
        Board board = new Board();
        List<String> grid = new ArrayList<>(Arrays.asList("X", "X", "X", "4", "5", "6", "7", "8", "9"));
        board.setGrid(grid);

        assertTrue(board.hasWin());
    }

    @Test
    public void boardHasWinLine2() {
        Board board = new Board();
        List<String> grid = new ArrayList<>(Arrays.asList("1", "2", "3", "X", "X", "X", "7", "8", "9"));
        board.setGrid(grid);

        assertTrue(board.hasWin());
    }

    @Test
    public void boardHasWinLine3() {
        Board board = new Board();
        List<String> grid = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "X", "X", "X"));
        board.setGrid(grid);

        assertTrue(board.hasWin());
    }

    @Test
    public void boardHasWinColumn1() {
        Board board = new Board();
        List<String> grid = new ArrayList<>(Arrays.asList("X", "2", "3", "X", "5", "6", "X", "8", "9"));
        board.setGrid(grid);

        assertTrue(board.hasWin());
    }

    @Test
    public void boardHasWinColumn2() {
        Board board = new Board();
        List<String> grid = new ArrayList<>(Arrays.asList("1", "X", "3", "4", "X", "6", "7", "X", "9"));
        board.setGrid(grid);

        assertTrue(board.hasWin());
    }

    @Test
    public void boardHasWinColumn3() {
        Board board = new Board();
        List<String> grid = new ArrayList<>(Arrays.asList("1", "2", "X", "4", "5", "X", "7", "8", "X"));
        board.setGrid(grid);

        assertTrue(board.hasWin());
    }

    @Test
    public void boardHasWinDiagonal1() {
        Board board = new Board();
        List<String> grid = new ArrayList<>(Arrays.asList("X", "2", "3", "4", "X", "6", "7", "8", "X"));
        board.setGrid(grid);

        assertTrue(board.hasWin());
    }

    @Test
    public void boardHasWinDiagonal2() {
        Board board = new Board();
        List<String> grid = new ArrayList<>(Arrays.asList("1", "2", "X", "4", "X", "6", "X", "8", "9"));
        board.setGrid(grid);

        assertTrue(board.hasWin());
    }

    @Test
    public void boardHasTie() {
        Board board = new Board();
        List<String> grid = new ArrayList<>(Arrays.asList("X", "O", "X", "O", "O", "X", "X", "X", "O"));
        board.setGrid(grid);

        assertTrue(board.hasTie());
    }
}
