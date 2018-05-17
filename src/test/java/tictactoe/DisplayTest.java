package tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;


public class DisplayTest {
    private Display display;
    private PrintStream printStream;
    private OutputStream outputStream;

    @Before
    public void setup() {
        outputStream = new ByteArrayOutputStream();
        printStream = new PrintStream(outputStream);
        InputStream inputStream = new ByteArrayInputStream("".getBytes());
        display = new Display(printStream, inputStream);
    }

    @Test
    public void printsGreeting() {
        display.printGreeting();
        assertThat(outputStream.toString(), containsString("Welcome to TicTacToe"));
    }

    @Test
    public void printsBoard() {
        Board board = new Board();
        display.printBoard(board);

        assertThat(outputStream.toString(), containsString("1 | 2 | 3\n" +
                "4 | 5 | 6\n" +
                "7 | 8 | 9\n"));
    }

    @Test
    public void announcesWinner() {
        display.announceWinner("X");
        assertThat(outputStream.toString(), containsString("Player X wins!"));
    }

    @Test
    public void announcesDraw() {
        display.announceDraw();
        assertThat(outputStream.toString(), containsString("Draw!"));
    }

    @Test
    public void printsGoodbye() {
        display.printGoodbye();
        assertThat(outputStream.toString(), containsString("Goodbye!"));
    }

    @Test
    public void announcesPlayerTurn() {
        display.announcePlayerTurn("X");
        assertThat(outputStream.toString(), containsString("Player X's turn!"));
    }

    @Test
    public void promptsPickMove() {
        display.promptPickMove("X");
        assertThat(outputStream.toString(), containsString("Player X, please pick a move (number between 1 and 9):\n"));
    }

    @Test
    public void promptsPlayerToCustomiseMark() {
        display.promptPlayerToCustomiseMark("X");
        assertThat(outputStream.toString(), containsString("Player X, please pick a custom mark of your choice:"));
    }
}

