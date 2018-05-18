package tictactoe;

import java.util.ArrayList;
import java.util.List;

public class HumanPlayer extends Player {
    private String mark;
    private Display display;

    HumanPlayer(String mark, Display display) {
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
}
