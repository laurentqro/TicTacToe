package tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Player implements IPlayer {
    private String mark;
    private Display display;

    Player(String mark, Display display) {
        this.display = display;
        this.mark = mark;
    }

    @Override
    public String getMark() {
        return mark;
    }

    @Override
    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public String getMove() throws InvalidInputException {
        return display.getMove();
    }

    @Override
    public String getMarkChoice() throws InvalidInputException {
        return display.getMarkChoice();
    }

    @Override
    public List<String> getMarkChoices() {
        List<String> choices = new ArrayList<>();
        return choices;
    }
}
