package TicTacToe;

import java.io.IOException;

public class Player {
    private String mark;
    private Display display;

    public Player(String mark, Display display) {
        this.display = display;
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }

    public int getMove() {
        return display.getInput();
    }
}
