package TicTacToe;

import java.io.*;
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
        List<String> grid = board.getGridAsList();

        String string = grid.get(0) + " | " + grid.get(1) + " | " + grid.get(2) + "\n"
                + grid.get(3) + " | " + grid.get(4) + " | " + grid.get(5) + "\n"
                + grid.get(6) + " | " + grid.get(7) + " | " + grid.get(8) + "\n";

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

    public String getInput() {
        try {
            String input;
            input = inputStream.readLine();
            return (input);
        } catch(IOException e) {
            return "";
        }
    }

    public void warnInvalidInput(String input) {
        printStream.println(input + " is not valid input.");
    }

    public void promptPlayerToCustomiseMark(String mark) {
        printStream.println("Player " + mark + ", please pick a custom mark of your choice:");
    }
}

