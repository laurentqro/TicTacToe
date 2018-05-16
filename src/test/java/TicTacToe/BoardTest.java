package TicTacToe;

import org.junit.Test;
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
        Board board = boardWith("X", "O", "X", "O", "O", "X", "X", "X", "O");
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
            board.mark(marks[i], i + 1);
        }
        return board;
    }
}
