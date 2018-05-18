package tictactoe;

public class HumanPlayer extends Player {
    private Display display;

    HumanPlayer(String mark, Display display) {
        super(mark);
        this.display = display;
    }

    @Override
    public String getMark() {
        return mark;
    }

    @Override
    public String getMove() {
        return display.getInput()
    }
}
