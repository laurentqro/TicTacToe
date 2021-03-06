package tictactoe;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BoardTest {
    @Test
    public void newBoardHasNoWin() {
        Board board = new Board();
        assertFalse(board.hasWin());
    }

    @Test
    public void boardHasWinLine1() {
        Board board = boardWith("X", "X", "X", "4", "5", "6", "7", "8", "9");
        assertTrue(board.hasWin());
    }

    @Test
    public void boardHasWinLine2() {
        Board board = boardWith("1", "2", "3", "X", "X", "X", "7", "8", "9");
        assertTrue(board.hasWin());
    }

    @Test
    public void boardHasWinLine3() {
        Board board = boardWith("1", "2", "3", "4", "5", "6", "X", "X", "X");
        assertTrue(board.hasWin());
    }

    @Test
    public void boardHasWinColumn1() {
        Board board = boardWith("X", "2", "3", "X", "5", "6", "X", "8", "9");
        assertTrue(board.hasWin());
    }

    @Test
    public void boardHasWinColumn2() {
        Board board = boardWith("1", "X", "3", "4", "X", "6", "5", "X", "9");
        assertTrue(board.hasWin());
    }

    @Test
    public void boardHasWinColumn3() {
        Board board = boardWith("1", "2", "X", "4", "5", "X", "7", "8", "X");
        assertTrue(board.hasWin());
    }

    @Test
    public void boardHasWinLeftDiagonal() {
        Board board = boardWith("X", "2", "3", "4", "X", "6", "7", "8", "X");
        assertTrue(board.hasWin());
    }

    @Test
    public void boardHasWinRightDiagonal() {
        Board board = boardWith("1", "2", "X", "4", "X", "6", "X", "8", "9");
        assertTrue(board.hasWin());
    }

    @Test
    public void boardHasTie() {
        Board board = boardWith("a", "O", "a", "O", "O", "a", "a", "a", "O");
        assertTrue(board.hasTie());
    }

    @Test
    public void boardHasNoWinner() {
        Board board = boardWith("1", "2", "3", "4", "5", "6", "7", "8", "9");
        assertEquals("", board.getWinner());
    }

    @Test
    public void boardHasWinner() {
        Board board = boardWith("X", "X", "X", "4", "5", "6", "7", "8", "9");
        assertEquals("X", board.getWinner());
    }


    private Board boardWith(String ...marks) {
        Board board = new Board();
        for (int i = 0; i < marks.length; i++) {
            int position = i + 1;
            board.markCellAtPosition(marks[i], position);
        }
        return board;
    }

    @Test
    public void returnsAvailableMoves() {
        Board board = boardWith("X");
        List<Cell> availableCells = board.getAvailableMoves();

        assert(availableCells.size() == 8);
    }

    @Test
    public void returnsNoAvailableMovesIfGameOver() {
        Board board = boardWith("X", "X", "X");
        List<Cell> availableCells = board.getAvailableMoves();

        assert(availableCells.isEmpty());
    }
}
