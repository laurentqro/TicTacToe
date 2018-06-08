package tictactoe;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ComputerPlayerTest {
    @Test
    public void playsToWin() {
        ComputerPlayer computer = new ComputerPlayer("O", new FakePlayer("X"));
        Board board = boardWith("O", "O", null,
                                        "X", "X", null,
                                        null, null, null);

        assertEquals("3", computer.getMove(board));
    }

    @Test
    public void blocksOpponent() {
        ComputerPlayer computer = new ComputerPlayer("O", new FakePlayer("X"));

        Board board = boardWith("X", null, "X",
                                        null, null, "O",
                                        null, null, null);

        assertEquals("2", computer.getMove(board));
    }

    private Board boardWith(String ...marks) {
        Board board = new Board();
        for (int i = 0; i < marks.length; i++) {
            try {
                board.markCellAtPosition(marks[i], i + 1);
            } catch(InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
        return board;
    }
}
