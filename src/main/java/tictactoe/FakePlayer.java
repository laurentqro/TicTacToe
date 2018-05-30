package tictactoe;

import java.util.Arrays;
import java.util.LinkedList;

public class FakePlayer extends Player {
    private LinkedList<String> choices;

    FakePlayer(String mark) {
        super(mark);
    }

    @Override
    public String getMove(Board _board) {
        return choices.pop();
    }

    public void setChoices(String... inputs) {
        LinkedList<String> choices = new LinkedList<>(Arrays.asList(inputs));
        this.choices = choices;
    }
}
