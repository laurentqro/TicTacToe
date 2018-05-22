package tictactoe;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
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

        playerX.setChoices("a");
        playerO.setChoices("b");

        session.start();

        verify(mockDisplay).promptPlayerToCustomiseMark("X");
    }

    @Test
    public void configuresCustomPlayerMarks() {
        Board board = boardWith("X", "X", "X", "4", "5", "6", "7", "8", "9");
        Game game = new Game(mockDisplay, board, playerX, playerO);
        Session session = new Session(game, mockDisplay);

        playerX.setChoices("ab");
        playerO.setChoices("cd");

        session.start();

        assertEquals("ab", playerX.getMark());
        assertEquals("cd", playerO.getMark());
    }

    @Test
    public void greetsPlayers() {
        Board board = boardWith("X", "X", "X", "4", "5", "6", "7", "8", "9");
        Game game = new Game(mockDisplay, board, playerX, playerO);
        game.play();

        verify(mockDisplay).printGreeting();
    }

    @Test
    public void oneIsValidInput() {
        Board board = boardWith("X", "X", "X", "4", "5", "6", "7", "8", "9");
        Game game = new Game(mockDisplay, board, playerX, playerO);
        Session session = new Session(game, mockDisplay);

        playerX.setChoices("a");
        playerO.setChoices("b");

        session.start();

        assertEquals("a", playerX.getMark());
        assertEquals("b", playerO.getMark());
    }

    private Board boardWith(String ...marks) {
        Board board = new Board();

        for (int i = 0; i < marks.length; i++) {
            int position = i + 1;
            try {
                board.markCellAtPosition(marks[i], position);
            } catch(InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
        return board;
    }
}