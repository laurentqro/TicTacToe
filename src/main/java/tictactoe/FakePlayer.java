package tictactoe;

import java.util.Arrays;
import java.util.LinkedList;

public class FakePlayer extends Player {
    private LinkedList<String> choices;
    private LinkedList<Integer> moves;

    FakePlayer(String mark) {
        super(mark);
    }

    public String getInput() {
        return choices.pop();
    }

    @Override
    public int getMove(Game game) {
        return moves.pop();
    }

    public void setChoices(String... inputs) {
        LinkedList<String> choices = new LinkedList<>(Arrays.asList(inputs));
        this.choices = choices;
    }
}
