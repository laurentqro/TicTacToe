package TicTacToe;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

public class GameTest {
    private Display mockDisplay;
    private Board board;
    private Game game;
    private FakePlayer playerX;
    private FakePlayer playerO;

    @Before
    public void setup() {
        mockDisplay = mock(Display.class);
        playerX = new FakePlayer("X");
        playerO = new FakePlayer("O");
    }

    @Test
    public void gameIsNotOverAtStart() {
        Board board = new Board();
        game = new Game(mockDisplay, board, playerX, playerO);
        assertFalse(game.isOver());
    }

    @Test
    public void gameIsOverWhenThereIsWinner() {
        board = boardWith("X", "X", "X", "4", "5", "6", "7", "8", "9");
        game = new Game(mockDisplay, board, playerX, playerO);
        assertTrue(game.isOver());
    }

    @Test
    public void gameIsOverWhenThereIsTie() {
        board = boardWith("X", "O", "X", "O", "O", "X", "X", "X", "O");
        game = new Game(mockDisplay, board, playerX, playerO);
        assertTrue(game.isOver());
    }

    @Test
    public void printsBoard() {
        board = boardWith("X", "X", "X", "4", "5", "6", "7", "8", "9");
        game = new Game(mockDisplay, board, playerX, playerO);
        game.play();
        verify(mockDisplay).printBoard(board);
    }

    @Test
    public void announcesWinner() {
        board = boardWith("X", "X", "X", "4", "5", "6", "7", "8", "9");
        game = new Game(mockDisplay, board, playerX, playerO);
        game.play();
        verify(mockDisplay).announceWinner("X");
    }

    @Test
    public void announcesDraw() {
        Board board = boardWith("X", "O", "X", "O", "O", "X", "X", "X", "O");
        game = new Game(mockDisplay, board, playerX, playerO);
        game.play();
        verify(mockDisplay).announceDraw();
    }

    @Test
    public void printsGoodbye() {
        board = boardWith("X", "X", "X", "4", "5", "6", "7", "8", "9");
        game = new Game(mockDisplay, board, playerX, playerO);
        game.play();
        verify(mockDisplay).printGoodbye();
    }

    @Test
    public void announcesPlayerTurn() {
        Board board = new Board();
        game = new Game(mockDisplay, board, playerX, playerO);
        playerX.setMoves("1");
        game.playTurn();
        verify(mockDisplay).announcePlayerTurn("X");
    }

    @Test
    public void marksBoard() {
        Board board = new Board();
        game = new Game(mockDisplay, board, playerX, playerO);
        playerX.setMoves("1");
        game.playTurn();
        assertTrue(board.getGridAsList().contains("X"));
    }

    @Test
    public void validatesUserInput() {
        Board board = new Board();
        playerX.setMoves("invalid input", "1");
        game = new Game(mockDisplay, board, playerX, playerO);
        game.playTurn();
        assertFalse(board.getGridAsList().contains("invalid input"));
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

