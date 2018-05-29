package tictactoe;

public class HumanPlayer extends Player {
    private Display display;

    HumanPlayer(String mark, Display display) {
        super(mark);
        this.display = display;
    }

    public String getInput() {
        return display.getInput();
    }

    public int getMove(Game game) {
        return display.getMove();
    }
}
