package tictactoe;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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

    public List<String> getMarkChoices() {
        return this.markChoices;
    }

    @Override
    public String getMove() {
        return moves.pop();
    }

    @Override
    public String getMarkChoice() {
        return markChoices.pop();
    }

    void setMoves(String... inputs) {
        LinkedList<String> moves = new LinkedList<>(Arrays.asList(inputs));
        this.moves = moves;
    }

    void setMarkChoices(String... inputs) {
        LinkedList<String> choices = new LinkedList<>(Arrays.asList(inputs));
        this.markChoices = choices;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
