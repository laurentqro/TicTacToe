package tictactoe;

public class Player implements IPlayer {
   private Display display;
   private String mark;

    Player(String mark, Display display) {
        this.display = display;
        this.mark = mark;
    }

    @Override
    public String getMark() {
        return mark;
    }

    @Override
    public String getInput() {
        return display.getInput();
    }

    @Override
    public String getMarkChoice() {
        return display.getInput();
    }

    @Override
    public void setMark(String mark) {
        this.mark = mark;
    }
}
