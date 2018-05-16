package TicTacToe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SessionTest {
    private FakePlayer playerX;
    private FakePlayer playerO;
    private Display mockDisplay;

    @Before
    public void setup() {
        playerX = new FakePlayer("X");
        playerO = new FakePlayer("O");
        mockDisplay = mock(Display.class);
    }

    @Test
    public void promptsPlayerToCustomiseMark() {
        Board board = boardWith("X", "X", "X", "4", "5", "6", "7", "8", "9");
        Game game = new Game(mockDisplay, board, playerX, playerO);
        Session session = new Session(game, mockDisplay);

        session.start();

        verify(mockDisplay).promptPlayerToCustomiseMark("X");
    }

    @Test
    public void configuresCustomPlayerMarks() {
        Board board = boardWith("X", "X", "X", "4", "5", "6", "7", "8", "9");
        Game game = new Game(mockDisplay, board, playerX, playerO);
        Session session = new Session(game, mockDisplay);

        playerX.setMarkChoice("foo");
        playerO.setMarkChoice("bar");

        session.start();

        assertEquals("foo", playerX.getMark());
        assertEquals("bar", playerO.getMark());
    }

    @Test
    public void greetsPlayers() {
        Board board = boardWith("X", "X", "X", "4", "5", "6", "7", "8", "9");
        Game game = new Game(mockDisplay, board, playerX, playerO);
        game.play();

        verify(mockDisplay).printGreeting();
    }


    private Board boardWith(String ...marks) {
        Board board = new Board();
        for (int i = 0; i < marks.length; i++) {
            board.mark(marks[i], i + 1);
        }
        return board;
    }
}