import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {
    @Test
    public void boardHasGrid() {
        Board board = new Board();
        assertArrayEquals(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"}, board.getGrid());
    }
}
