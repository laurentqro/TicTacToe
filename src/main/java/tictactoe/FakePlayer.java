package tictactoe;

import java.util.Arrays;
import java.util.LinkedList;

public class FakePlayer extends Player {
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
