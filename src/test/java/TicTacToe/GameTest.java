package TicTacToe;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class GameTest {
    private Display mockDisplay = mock(Display.class);

    @Test
    public void gameIsNotOverAtStart() {
        Board board = new Board();
        Game game = new Game(mockDisplay, board);

        assertFalse(game.isOver());
    }

    @Test
    public void gameIsOverWhenThereIsWinner() {
        Board board = boardWith("X", "X", "X", "4", "5", "6", "7", "8", "9");
        Game game = new Game(mockDisplay, board);

        assertTrue(game.isOver());
    }

    @Test
    public void gameIsOverWhenThereIsTie() {
        Board board = boardWith("X", "O", "X", "O", "O", "X", "X", "X", "O");
        Game game = new Game(mockDisplay, board);

        assertTrue(game.isOver());
    }

    @Test
    public void greetsPlayers() {
        Board board = boardWith("X", "X", "X", "4", "5", "6", "7", "8", "9");
        Game game = new Game(mockDisplay, board);
        game.play();

        verify(mockDisplay).printGreeting();
    }

    @Test
    public void printsBoard() {
        Board board = boardWith("X", "X", "X", "4", "5", "6", "7", "8", "9");
        Game game = new Game(mockDisplay, board);
        game.play();

        verify(mockDisplay).printBoard(board);
    }

    @Test
    public void announcesWinner() {
        Board board = boardWith("X", "X", "X", "4", "5", "6", "7", "8", "9");
        Game game = new Game(mockDisplay, board);
        game.play();

        verify(mockDisplay).announceWinner("X");
    }

    @Test
    public void announcesDraw() {
        Board board = new Board();
        Game game = new Game(mockDisplay, board);
        game.play();

        verify(mockDisplay).announceWinner("X");
    }

    @Test
    public void printsGoodbye() {
        Board board = boardWith("X", "X", "X", "4", "5", "6", "7", "8", "9");
        Game game = new Game(mockDisplay, board);
        game.play();

        verify(mockDisplay).printGoodbye();
    }

    @Test
    public void announcesPlayerTurn() {
        Board board = new Board();
        Game game = new Game(mockDisplay, board);
        game.playTurn();

        verify(mockDisplay).announcePlayerTurn("X");
    }

    @Test
    public void marksBoard() {
        Board board = new Board();
        Game game = new Game(mockDisplay, board);
        game.playTurn();

        assertTrue(board.getGridAsList().contains("X"));
    }

    private Board boardWith(String ...marks) {
        Board board = new Board();
        for (int i = 0; i < marks.length; i++) {
            board.mark(marks[i], i + 1);
        }
        return board;
    }
}

