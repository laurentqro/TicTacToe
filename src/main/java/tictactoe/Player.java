package tictactoe;

public abstract class Player {
    protected String mark;
    private int MAX_MARK_LENGTH = 2;

    public Player(String mark) {
        this.mark = mark;
    }

    abstract String getMark();

    abstract String getMove();

    public void setMark(String mark) {
        if (isValidMark(mark)) {
            this.mark = mark;
        } else {
            throw new InvalidInputException("Invalid input, please choose an emoji or mark no longer than two characters.");
        }
    }

    protected boolean isValidMark(String input) {
        return !input.isEmpty() & input.length() <= MAX_MARK_LENGTH;
    }
}
