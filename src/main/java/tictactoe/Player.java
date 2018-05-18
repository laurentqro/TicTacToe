package tictactoe;

public abstract class Player {
    abstract String getMark();
    abstract String getMove() throws InvalidInputException;
    abstract String getMarkChoice() throws InvalidInputException;
    abstract void setMark(String foo);
}
