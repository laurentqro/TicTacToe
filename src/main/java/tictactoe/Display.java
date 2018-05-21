package tictactoe;

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

    public int getMove() {
        try {
            return Integer.parseInt(inputStream.readLine());
        } catch (IOException e) {
            return 0;
        }
    }

    public String getInput() {
        try {
            return inputStream.readLine();
        } catch (IOException e) {
            return "";
        }
    }

    public void print(String message) {
        printStream.println(message);
    }
}

