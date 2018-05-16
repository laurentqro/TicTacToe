package TicTacToe;

import java.util.Arrays;
import java.util.LinkedList;

public class FakePlayer implements IPlayer {
    private LinkedList<String> moves;
    private String mark;

    FakePlayer(String mark) {
        this.mark = mark;
    }

    @Override
    public String getMark() {
        return mark;
    }

    @Override
    public String getInput() {
        return moves.pop();
    }

    public void setMoves(String ...inputs) {
        LinkedList<String> moves = new LinkedList<>(Arrays.asList(inputs));
        this.moves = moves;
    }
}
