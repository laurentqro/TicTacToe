package tictactoe;

public class Cell {
    public static final int MAX_MARK_LENGTH = 2;
    private String mark;
    private int position;

    public Cell(int position) {
        this.position = position;
        this.mark = null;
    }

    public String getMark() {
        return mark;
    }

    public String toString() {
        if(isMarked()) {
            return mark;
        } else {
           return Integer.toString(position);
        }
    }

    public void setMark(String mark) throws InvalidInputException {
        if(isMarked()) {
            throw new InvalidInputException("This position is already taken, please choose an available position.");
        } else {
            this.mark = mark;
        }
    }

    public boolean isMarked() {
        return mark != null;
    }
}
