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

    public String toString() {
        if(isMarked()) {
            return mark;
        } else {
           return Integer.toString(position);
        }
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public boolean isMarked() {
        return mark != null;
    }
}
