package tictactoe;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Display {
    public OutputStream outputStream;
    private PrintStream printStream;
    private BufferedReader inputStream;

    public Display(PrintStream outputStream, InputStream inputStream) {
        this.outputStream = outputStream;
        this.printStream = new PrintStream(outputStream);
        this.inputStream = new BufferedReader(new InputStreamReader(inputStream));
    }

    public void printGreeting() {
        printStream.println("Welcome to TicTacToe");
    }

    public void printBoard(Board board) {
        List<Cell> cells = board.getGridAsList();

        String string = cells.get(0).toString() + " | " + cells.get(1).toString() + " | " + cells.get(2).toString() + "\n"
                      + cells.get(3).toString() + " | " + cells.get(4).toString() + " | " + cells.get(5).toString() + "\n"
                      + cells.get(6).toString() + " | " + cells.get(7).toString() + " | " + cells.get(8).toString() + "\n";

        printStream.println(string);
    }

    public void announceWinner(String mark) {
        printStream.println("Player " + mark + " wins!");
    }

    public void announceDraw() {
        printStream.println("Draw!");
    }

    public void announcePlayerTurn(String mark) {
        printStream.println("Player " + mark + "\'s turn!");
    }

    public void printGoodbye() {
        printStream.println("Goodbye!");
    }

    public void promptPickMove(String mark) {
        printStream.println("Player " + mark + ", please pick a move (number between 1 and 9):\n");
    }

    public void promptPlayerToCustomiseMark(String mark) {
        printStream.println("Player " + mark + ", please pick a custom mark of your choice:");
    }

    public String getMarkChoice() throws InvalidInputException {
        try {
            String input;
            input = inputStream.readLine();

            if (isValidMark(input)) {
                return sanitize(input);
            } else {
                throw new InvalidInputException("Invalid input, please choose an emoji or mark no longer than two characters.");
            }
        } catch(IOException e) {
            return "";
        }
    }

    private boolean isValidMark(String input) {
        return !input.isEmpty() & input.length() <= Cell.MAX_MARK_LENGTH;
    }

    private String sanitize(String input) {
        return input.replaceAll("\\s+","");
    }

    public String getMove() throws InvalidInputException {
        String input = "";
        try {
            input = inputStream.readLine();

            if (isValidMove(input)) {
                return input;
            } else {
                throw new InvalidInputException("Invalid input, please enter a number between 1 and 9.");
            }
        } catch(IOException e) {
            return "";
        }
    }

    private boolean isValidMove(String input) {
        List<String> acceptedInputs = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
        return acceptedInputs.contains(input);
    }

    public void print(String message) {
        printStream.println(message);
    }
}

