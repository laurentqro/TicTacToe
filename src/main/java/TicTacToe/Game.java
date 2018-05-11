package TicTacToe;

import java.io.IOException;

public class Game {
    private Board board;
    private Display display;
    private Player currentPlayer;

    Game(Display display, Board board) {
        this.display = display;
        this.board = board;
        this.currentPlayer = new Player("X", display);
    }

    public void play() {
        startGame();

        while (!isOver()) {
            playTurn();
        }

        endGame();
    }

    public boolean isOver() {
        return board.hasWin() || board.hasTie();
    }

    private void startGame() {
        display.printGreeting();
        display.printBoard(board);
    }

    public void playTurn() {
        display.announcePlayerTurn(currentPlayer.getMark());
        display.promptPickMove(currentPlayer.getMark());
        markBoard();
        switchPlayers();
        display.printBoard(board);
    }

    private void endGame() {
        if (board.hasWin()) {
            display.announceWinner(board.getWinner());
        } else {
            display.announceDraw();
        }
        display.printGoodbye();
    }

    private void markBoard() {
        board.mark(currentPlayer.getMark(), getMove());
    }

    private int getMove() {
        return currentPlayer.getMove();
    }

    private void switchPlayers() {
        if (currentPlayer.getMark().equals("X")) {
            this.currentPlayer = new Player("O", display);
        } else {
            this.currentPlayer = new Player("X", display);
        }
    }
}