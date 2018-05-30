package tictactoe;

public class Cell {
    private String mark;
    private int position;

    public Cell(int position) {
        this.position = position;
        this.mark = null;
    }

    public String getMark() {
        return mark;
    }

    public int getPosition() {
        return position;
    }

    public String toString() {
        if(isMarked()) {
            return mark;
        } else {
           return Integer.toString(position);
        }
    }

    public void setMark(String mark) {
        if(isMarked()) {
            throw new InvalidInputException("This position is already taken, please choose an available position.");
        } else {
            this.mark = mark;
        }
    }

    public boolean isMarked() {
        return mark != null;
    }

    public boolean isAvailable() { return !isMarked(); }

    public void reset() {
        mark = null;
    }
}
