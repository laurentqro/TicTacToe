package tictactoe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ComputerPlayerTest {
    @Test
    public void playsToWin() {
        ComputerPlayer computer = new ComputerPlayer("🖥");
        Board board = boardWith("X", "X", "3",
                                "O", "O", "6",
                                "7", "8", "9");

        assertEquals("3", computer.getInput(board));
    }

    @Test
    public void blocksOpponent() {
        ComputerPlayer computer = new ComputerPlayer("🖥");

        Board board = boardWith("X", "O", "X",
                "4", "O", "6",
                "O", "X", "X");

        assertEquals("6", computer.getInput(board));
    }

    private Board boardWith(String ...marks) {
        Board board = new Board();
        for (int i = 0; i < marks.length; i++) {
            String position = Integer.toString(i + 1);
            try {
                board.markCellAtPosition(marks[i], position);
            } catch(InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
        return board;
    }
}