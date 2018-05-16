package TicTacToe;

import java.util.Arrays;
import java.util.LinkedList;

public class FakePlayer implements IPlayer {
    private LinkedList<String> moves;
    private LinkedList<String> markChoices;
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

    void setMoves(String... inputs) {
        LinkedList<String> moves = new LinkedList<>(Arrays.asList(inputs));
        this.moves = moves;
    }

    @Override
    public String getMarkChoice() {
        return markChoices.pop();
    }

    void setMarkChoices(String... inputs) {
        LinkedList<String> choices = new LinkedList<>(Arrays.asList(inputs));
        this.markChoices = choices;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
