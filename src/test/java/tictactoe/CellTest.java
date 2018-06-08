package tictactoe;

import org.junit.Test;

import static org.junit.Assert.*;

public class CellTest {

    @Test
    public void reset() {
        Cell cell = new Cell(1);
        cell.setMark("X");
        assertTrue(cell.getMark() == "X");
        cell.reset();
        assertTrue(cell.getMark() == null);
    }
}