package tictactoe;

import java.util.List;

public interface IPlayer {
    String getMark();
    String getMove() throws InvalidInputException;
    String getMarkChoice() throws InvalidInputException;
    void setMark(String foo);

    List<String> getMarkChoices();
}
