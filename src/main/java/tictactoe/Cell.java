package tictactoe;

public class Cell {
    private String mark;

    public Cell() {
        this.mark = null;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public boolean isMarked() {
        return mark != null;
    }
}
