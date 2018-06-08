package tictactoe;

public class HumanPlayer extends Player {
    private Display display;

    HumanPlayer(String mark, Display display) {
        super(mark);
        this.display = display;
    }

    @Override
    public String getMove(Board _board) {
        return display.getInput();
    }
}
