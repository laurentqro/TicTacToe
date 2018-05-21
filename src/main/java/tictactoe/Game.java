package tictactoe;

class Game {
    private Board board;
    private Display display;
    private Player currentPlayer;
    Player playerX;
    Player playerO;

    Game(Display display, Board board, Player playerX, Player playerO) {
        this.display = display;
        this.board = board;
        this.playerX = playerX;
        this.playerO = playerO;
        this.currentPlayer = playerX;
    }

    void play() {
        startGame();

        while (!isOver()) {
            playTurn();
        }

        endGame();
    }

    boolean isOver() {
        return board.hasWin() || board.hasTie();
    }

    private void startGame() {
        display.printGreeting();
        display.printBoard(board);
    }

    void playTurn() {
        display.announcePlayerTurn(currentPlayer.getMark());
        display.promptPickMove(currentPlayer.getMark());
        markBoard(getMove());
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

    private void markBoard(String input) {
        try {
            board.markCellAtPosition(currentPlayer.getMark(), input);
        } catch(InvalidInputException e) {
            display.print(e.getMessage());
            getMove();
        }
    }

    private String getMove() {
        try {
            return currentPlayer.getInput();
        } catch(InvalidInputException e) {
            display.print(e.getMessage());
            return getMove();
        }
    }

    private void switchPlayers() {
        if (currentPlayer == playerX) {
            currentPlayer = playerO;
        } else {
            currentPlayer = playerX;
        }
    }
}
